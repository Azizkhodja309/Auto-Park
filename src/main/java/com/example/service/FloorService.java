package com.example.service;

import com.example.mapper.FloorMapper;
import com.example.model.DTO.floorDTO.FloorCreateDTO;
import com.example.model.DTO.floorDTO.FloorDTO;
import com.example.model.entity.Floor;
import com.example.repository.FloorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService {
    private final FloorRepository floorRepository;
    private final FloorMapper floorMapper;

    public FloorService(FloorRepository floorRepository, FloorMapper floorMapper) {
        this.floorRepository = floorRepository;
        this.floorMapper = floorMapper;
    }

    public List<FloorDTO> getAllByParkId(Long id) {
        return floorRepository.getAllByParkId(id);
    }

    public void create(long parkId, FloorCreateDTO createDTO) {
        Floor floor = floorMapper.fromCreateDTO(createDTO, parkId);
        floorRepository.create(floor);
    }

    public Long getById(Long floorId) {
        return floorRepository.getById(floorId).getParkId();
    }
}
