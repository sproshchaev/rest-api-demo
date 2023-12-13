package com.prosoft.service;

import java.util.List;

public interface SchemaService {
    String getCurrSchema();

    boolean setCurrSchema(String[] schemes);

    List<String> getAllSchemes();

    boolean isExist(String scheme);
}
