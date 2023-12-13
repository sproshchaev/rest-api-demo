package com.prosoft.repository.impl;

import com.prosoft.repository.SchemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchemaRepositoryImpl implements SchemaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SchemaRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getCurrSchema() {
        return jdbcTemplate.queryForObject("select current_schema", String.class);
    }

    @Override
    public void setCurrSchema(String[] schemes) {
        jdbcTemplate.update("set search_path to " + String.join(", ", schemes));
    }

    @Override
    public List<String> getAllSchemes() {
        return jdbcTemplate.queryForList("select schema_name from INFORMATION_SCHEMA.SCHEMATA", String.class);
    }
}
