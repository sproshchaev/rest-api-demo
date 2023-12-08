package com.prosoft.service.impl;

import com.prosoft.domain.Well;
import com.prosoft.feign.ServerProxy;
import com.prosoft.service.WellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WellServiceFeign implements WellService {

    private final ServerProxy serverProxy;

    @Autowired
    public WellServiceFeign(ServerProxy serverProxy) {
        this.serverProxy = serverProxy;
    }

    @Override
    public Well getWell(String project, Long uwi) {
        return serverProxy.getWell(project, uwi);
    }

}
