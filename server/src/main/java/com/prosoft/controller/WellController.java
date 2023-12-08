package com.prosoft.controller;

import com.prosoft.domain.Well;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class WellController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/wells/{project}/{uwi}")
    public Well getWell(@PathVariable("project") String project, @PathVariable("uwi") Long uwi) {
        return new Well(uwi, "whell #" + uwi); // TODO: 08.12.2023 заглушка
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/wells/{project}")
    public List<Well> getWellList(@PathVariable("project") String project) {
        return Collections.emptyList(); // TODO: 08.12.2023 заглушка
    }


}
