package com.lucasjosino.parkingcontrolapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParkingNotFoundException extends RuntimeException {
    public ParkingNotFoundException(UUID id) {
        super("Parking not found with Id: " + id);
    }
}
