package com.prosoft.service.impl;

import com.prosoft.repository.SchemaRepository;
import com.prosoft.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SchemaServiceImpl implements SchemaService {
    private final SchemaRepository schemaRepository;

    @Autowired
    public SchemaServiceImpl(SchemaRepository schemaRepository) {
        this.schemaRepository = schemaRepository;
    }

    @Override
    public String getCurrSchema() {
        return schemaRepository.getCurrSchema();
    }

    @Override
    public boolean setCurrSchema(String[] schemes) {
        if (isExist(schemes[0])) {
            schemaRepository.setCurrSchema(Arrays.stream(schemes).map(String::toLowerCase).toArray(String[]::new));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<String> getAllSchemes() {
        return schemaRepository.getAllSchemes();
    }

    @Override
    public boolean isExist(String scheme) {
        return schemaRepository.getAllSchemes().contains(scheme.toLowerCase());
    }
}
