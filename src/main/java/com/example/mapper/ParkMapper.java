package com.example.mapper;

import com.example.model.DTO.parkDTO.ParkCreateDto;
import com.example.model.DTO.parkDTO.ParkUpdateDto;
import com.example.model.entity.AutoPark;
import org.springframework.stereotype.Component;

@Component
public class ParkMapper {
    public AutoPark fromCreateDTO(ParkCreateDto parkDto) {
        AutoPark autoPark = new AutoPark();

        autoPark.setName(parkDto.getName());
        return autoPark;
    }

    public AutoPark fromUpdateDTO(ParkUpdateDto parkDto) {
        AutoPark autoPark = new AutoPark();

        autoPark.setId(parkDto.getId());
        autoPark.setName(parkDto.getName());
        return autoPark;
    }
}
