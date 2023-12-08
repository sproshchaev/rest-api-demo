package com.prosoft.service.impl;

import com.prosoft.domain.Well;
import com.prosoft.service.WellService;
import feign.FeignException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("WellServiceFeign test:")
class WellServiceFeignTest {

    @Autowired
    private WellService wellService;

    @Test
    @DisplayName("getWell() success")
    void getWell_Success() {
        Well well = wellService.getWell("some_project", 101L);
        assertNotNull(well);
    }

    @Test
    @DisplayName("getWell() fail")
    void getWell_Fail() {
        assertThrows(FeignException.class, () -> {
            wellService.getWell("some_project", 100L);
        });
    }


}