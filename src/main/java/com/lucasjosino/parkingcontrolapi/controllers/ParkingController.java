package com.lucasjosino.parkingcontrolapi.controllers;

import com.lucasjosino.parkingcontrolapi.models.dto.ParkingDTOModel;
import com.lucasjosino.parkingcontrolapi.services.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/parkings")
@SuppressWarnings("SpellCheckingInspection")
public class ParkingController {
    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping
    public ResponseEntity<List<ParkingDTOModel>> findAll() {
        return ResponseEntity.ok(parkingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTOModel> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(parkingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ParkingDTOModel> create(@RequestBody ParkingDTOModel parking) {
        ParkingDTOModel res = parkingService.create(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patch(@RequestBody ParkingDTOModel parking, @PathVariable UUID id) {
        parkingService.update(parking, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
