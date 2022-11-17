package com.lucasjosino.parkingcontrolapi.controllers.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingMapper {
    private final ModelMapper MODEL_MAPPER;

    @Autowired
    public ParkingMapper(ModelMapper MODEL_MAPPER) {
        this.MODEL_MAPPER = MODEL_MAPPER;
    }
}
