package com.prosoft.controller;

import com.prosoft.domain.Well;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WellController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/wells/{project}/{uwi}")
    public Well getWell(@PathVariable("project") String project, @PathVariable("uwi") Long uwi) {
        return new Well(1L, "whell #1");
    }

}
