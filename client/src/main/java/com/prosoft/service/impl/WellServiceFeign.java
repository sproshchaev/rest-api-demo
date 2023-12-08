package com.prosoft.service.impl;

import com.prosoft.domain.Well;
import com.prosoft.feign.ServerProxy;
import com.prosoft.service.WellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class WellServiceFeign implements WellService {
    private final ServerProxy serverProxy;
    private final RestTemplate restTemplate;

    @Autowired
    public WellServiceFeign(ServerProxy serverProxy, RestTemplate restTemplate) {
        this.serverProxy = serverProxy;
        this.restTemplate = restTemplate;
    }

    @Override
    public Well getWell(String project, Long uwi) {
        return serverProxy.getWell(project, uwi);
    }

    @Override
    public List<Well> getWells(String project) {
        ResponseEntity<Well[]> response = restTemplate.getForEntity("http://localhost:8081/wells/" + project, Well[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

}
