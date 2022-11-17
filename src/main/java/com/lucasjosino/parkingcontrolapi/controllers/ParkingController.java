package com.lucasjosino.parkingcontrolapi.controllers;

import com.lucasjosino.parkingcontrolapi.models.ParkingModel;
import com.lucasjosino.parkingcontrolapi.services.ParkingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<ParkingModel>> findAll() {
        return ResponseEntity.ok(parkingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingModel> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(parkingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ParkingModel> create(@RequestBody ParkingModel parking) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ParkingModel());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        return ResponseEntity.noContent().build();
    }
}
