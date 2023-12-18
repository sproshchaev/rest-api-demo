package com.prosoft.feign;

import com.prosoft.config.FeignClientConfiguration;
import com.prosoft.domain.Well;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${geoeditor.well-service.name}", url = "${geoeditor.well-service.host}", configuration = FeignClientConfiguration.class)
public interface ServerProxy {

    @GetMapping("/wells/{project}/{uwi}")
    Well getWell(@PathVariable("project") String project, @PathVariable("uwi") Long uwi);

}
