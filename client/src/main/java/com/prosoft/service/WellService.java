package com.prosoft.service;

import com.prosoft.domain.Well;

import java.util.List;

public interface WellService {
    Well getWell(String project, Long uwi);
    List<Well> getWells(String project);
}
