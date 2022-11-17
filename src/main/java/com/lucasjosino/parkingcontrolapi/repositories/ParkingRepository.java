package com.lucasjosino.parkingcontrolapi.repositories;

import com.lucasjosino.parkingcontrolapi.models.ParkingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingModel, UUID> {
}
