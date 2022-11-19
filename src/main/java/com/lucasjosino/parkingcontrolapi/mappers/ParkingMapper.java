package com.lucasjosino.parkingcontrolapi.controllers.mappers;

import com.lucasjosino.parkingcontrolapi.models.ParkingModel;
import com.lucasjosino.parkingcontrolapi.models.dto.ParkingDTOModel;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {
    @Bean
    private ModelMapper mapper() {
        ModelMapper MODEL_MAPPER = new ModelMapper();
        MODEL_MAPPER.getConfiguration()
                .setSkipNullEnabled(true)
                .setPropertyCondition(Conditions.isNotNull());
        return MODEL_MAPPER;
    }

    public ParkingDTOModel toParkingDTO(ParkingModel model) {
        return mapper().map(model, ParkingDTOModel.class);
    }

    public List<ParkingDTOModel> toParkingDTOList(List<ParkingModel> models) {
        return models.stream().map(this::toParkingDTO).collect(Collectors.toList());
    }

    public ParkingModel toParking(ParkingDTOModel model) {
        return mapper().map(model, ParkingModel.class);
    }
}
