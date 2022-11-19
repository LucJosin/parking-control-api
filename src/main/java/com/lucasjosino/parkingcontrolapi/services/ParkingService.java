package com.lucasjosino.parkingcontrolapi.services;

import com.lucasjosino.parkingcontrolapi.mappers.ParkingMapper;
import com.lucasjosino.parkingcontrolapi.exceptions.ParkingNotFoundException;
import com.lucasjosino.parkingcontrolapi.models.ParkingModel;
import com.lucasjosino.parkingcontrolapi.models.dto.ParkingDTOModel;
import com.lucasjosino.parkingcontrolapi.repositories.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingService {
    private final ParkingRepository parkingRepository;

    private final ParkingMapper parkingMapper;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository, ParkingMapper parkingMapper) {
        this.parkingRepository = parkingRepository;
        this.parkingMapper = parkingMapper;
    }

    @Transactional(readOnly = true)
    public List<ParkingDTOModel> findAll() {
        List<ParkingModel> res = parkingRepository.findAll();
        return parkingMapper.toParkingDTOList(res);
    }

    @Transactional(readOnly = true)
    public ParkingDTOModel findById(UUID id) {
        ParkingModel res = parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
        return parkingMapper.toParkingDTO(res);
    }

    @Transactional
    public ParkingDTOModel create(ParkingDTOModel model) {
        ParkingModel convRes = parkingMapper.toParking(model);
        parkingRepository.save(convRes);
        return model;
    }

    @Transactional
    public void update(ParkingDTOModel updModel, UUID id) {
        ParkingModel newModel = parkingRepository.getReferenceById(id);
        newModel.setId(id);
        newModel.setLicense(Optional.ofNullable(updModel.getLicense()).orElse(newModel.getLicense()));
        newModel.setState(Optional.ofNullable(updModel.getState()).orElse(newModel.getState()));
        newModel.setModel(Optional.ofNullable(updModel.getModel()).orElse(newModel.getModel()));
        newModel.setBill(Optional.ofNullable(updModel.getBill()).orElse(newModel.getBill()));
        newModel.setColor(Optional.of(updModel.getColor()).orElse(newModel.getColor()));
        newModel.setEntryDate(Optional.ofNullable(updModel.getEntryDate()).orElse(newModel.getEntryDate()));
        newModel.setExitDate(Optional.ofNullable(updModel.getExitDate()).orElse(newModel.getExitDate()));
        parkingRepository.save(newModel);
    }

    @Transactional
    public void delete(UUID id) {
        if (!parkingRepository.existsById(id)) throw new ParkingNotFoundException(id);
        parkingRepository.deleteById(id);
    }
}
