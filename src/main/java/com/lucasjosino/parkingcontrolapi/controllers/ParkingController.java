package com.lucasjosino.parkingcontrolapi.controllers;

import com.lucasjosino.parkingcontrolapi.models.dto.ParkingDTOModel;
import com.lucasjosino.parkingcontrolapi.services.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/parkings")
@Api(tags = "Parking Controller")
@SuppressWarnings("SpellCheckingInspection")
public class ParkingController {
    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingDTOModel>> findAll() {
        return ResponseEntity.ok(parkingService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("Find a single parking")
    public ResponseEntity<ParkingDTOModel> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(parkingService.findById(id));
    }

    @PostMapping
    @ApiOperation("Create parking")
    public ResponseEntity<ParkingDTOModel> create(@RequestBody ParkingDTOModel parking) {
        ParkingDTOModel res = parkingService.create(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PatchMapping("/{id}")
    @ApiOperation("Update parking")
    public ResponseEntity<Void> patch(@RequestBody ParkingDTOModel parking, @PathVariable UUID id) {
        parkingService.update(parking, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete parking")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
