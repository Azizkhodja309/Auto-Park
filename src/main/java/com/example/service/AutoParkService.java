package com.example.service;

import com.example.model.entity.AutoPark;
import com.example.model.DTO.parkDTO.ParkCreateDto;
import com.example.repository.AutoParkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoParkService {
    private final AutoParkRepository autoParkRepository;

    public AutoParkService(AutoParkRepository autoParkRepository) {
        this.autoParkRepository = autoParkRepository;
    }

    public void create(ParkCreateDto parkDto) {
        autoParkRepository.create(parkDto);
    }

    public List<AutoPark> getAll() {
        return null;
    }
}
