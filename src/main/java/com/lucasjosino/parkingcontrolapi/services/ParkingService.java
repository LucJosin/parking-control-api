package com.lucasjosino.parkingcontrolapi.services;

import com.lucasjosino.parkingcontrolapi.exceptions.ParkingNotFoundException;
import com.lucasjosino.parkingcontrolapi.models.ParkingModel;
import com.lucasjosino.parkingcontrolapi.repositories.ParkingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ParkingService {
    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Transactional(readOnly = true)
    public List<ParkingModel> findAll() {
        return parkingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ParkingModel findById(UUID id) {
        return parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
    }
}
