package com.example.repository;

import com.example.model.DTO.placeDTO.PlaceDto;
import com.example.model.entity.Place;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaceRepository {
    private final JdbcTemplate jdbcTemplate;

    public PlaceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PlaceDto> getAllByFloorId(Long floorId) {
        String sql = "select * from place where floor_id = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PlaceDto.class), floorId);
    }

    public void create(PlaceDto placeDto) {
        String sql = "insert into place (floor_id, name) values (?, ?)";
        jdbcTemplate.update(sql, placeDto.getFloorId(), placeDto.getName());
    }
}
