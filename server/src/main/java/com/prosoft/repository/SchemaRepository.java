package com.prosoft.repository;

import java.util.List;

public interface SchemaRepository {
    String getCurrSchema();
    void setCurrSchema(String[] schemes);
    List<String> getAllSchemes();
}
