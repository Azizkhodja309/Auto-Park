package com.example.repository;

import com.example.model.entity.AutoPark;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutoParkRepository {
    private final JdbcTemplate jdbcTemplate;

    public AutoParkRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(AutoPark park) {
        String sql = "insert into auto_park (name) values (?)";
        jdbcTemplate.update(sql, park.getName());
    }

    public List<AutoPark> getAll() {
        String sql = "select * from auto_park";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(AutoPark.class));
    }

    public AutoPark getById(Long id) {
        String sql = "select * from auto_park where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(AutoPark.class));
    }

    public void delete(Long id) {
        String sql = "delete from auto_park where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(AutoPark park) {
        String sql = "update auto_park set park_name = ? where id = ?";
        jdbcTemplate.update(sql,park.getName(), park.getId());
    }
}
