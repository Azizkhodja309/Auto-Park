package com.example.repository;

import com.example.model.DTO.floorDTO.FloorDTO;
import com.example.model.entity.Floor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FloorRepository {
    private final JdbcTemplate jdbcTemplate;

    public FloorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FloorDTO> getAllByParkId(Long id) {
        String sql = "select * from floor where park_id = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(FloorDTO.class), id);
    }

    public void create(Floor floor) {
        String sql = "insert into floor (name, park_id) values (?, ?)";
        jdbcTemplate.update(sql, floor.getName(), floor.getParkId());
    }

    public Floor getById(Long floorId) {
        String sql = "select * from floor where id = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Floor.class), floorId);
    }
}
