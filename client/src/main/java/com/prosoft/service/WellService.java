package com.prosoft.service;

import com.prosoft.domain.Well;

public interface WellService {
    Well getWell(String project, Long uwi);
}
