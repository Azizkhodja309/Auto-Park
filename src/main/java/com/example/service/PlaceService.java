package com.example.service;

import com.example.model.DTO.placeDTO.PlaceDto;
import com.example.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<PlaceDto> getAllByFloorId(Long floorId) {
        return placeRepository.getAllByFloorId(floorId);
    }

    public void create(PlaceDto placeDto) {
        placeRepository.create(placeDto);
    }
}
