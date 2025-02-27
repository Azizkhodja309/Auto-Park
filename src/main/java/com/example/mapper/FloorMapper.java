package com.example.mapper;

import com.example.model.DTO.floorDTO.FloorCreateDTO;
import com.example.model.DTO.floorDTO.FloorUpdateDTO;
import com.example.model.entity.Floor;
import org.springframework.stereotype.Component;

@Component
public class FloorMapper {
    public Floor fromCreateDTO(FloorCreateDTO floorDto, Long parkId) {
        Floor floor = new Floor();

        floor.setName(floorDto.getName());
        floor.setParkId(parkId);
        return floor;
    }

    public Floor fromUpdateDTO(FloorUpdateDTO floorDto) {
        Floor floor = new Floor();

        floor.setId(floorDto.getId());
        floor.setName(floorDto.getName());
        return floor;
    }
}
