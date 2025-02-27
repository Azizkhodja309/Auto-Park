package com.example.service;

import com.example.mapper.ParkMapper;
import com.example.model.DTO.parkDTO.ParkUpdateDto;
import com.example.model.entity.AutoPark;
import com.example.model.DTO.parkDTO.ParkCreateDto;
import com.example.repository.AutoParkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoParkService {
    private final AutoParkRepository autoParkRepository;
    private final ParkMapper mapper;

    public AutoParkService(AutoParkRepository autoParkRepository, ParkMapper mapper) {
        this.autoParkRepository = autoParkRepository;
        this.mapper = mapper;
    }

    public void create(ParkCreateDto parkDto) {
        AutoPark autoPark = mapper.fromCreateDTO(parkDto);
        autoParkRepository.create(autoPark);
    }

    public List<AutoPark> getAll() {
        return autoParkRepository.getAll();
    }

    public void update(ParkUpdateDto parkDto) {
        AutoPark autoPark = mapper.fromUpdateDTO(parkDto);
        autoParkRepository.update(autoPark);
    }

    public void delete(Long id) {
        autoParkRepository.delete(id);
    }
}
