package com.prosoft.service.impl;

import com.prosoft.domain.Well;
import com.prosoft.service.WellService;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@SpringBootTest
@DisplayName("WellServiceFeign test:")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WellServiceFeignTest {
    private final static String PROJECT_EXISTS = "test_project";
    private final static long UWI_PERMIT = 101L;
    private final static long UWI_DENY = 100L;

    @Autowired
    private WellService wellService;

    @Test
    @DisplayName("getWell() success")
    void getWell_Success() {
        Well well = wellService.getWell(PROJECT_EXISTS, UWI_PERMIT);
        log.info("getWell(" + PROJECT_EXISTS + "," + UWI_PERMIT + ")=" + well.toString());
        assertNotNull(well);
    }

    @Test
    @DisplayName("getWell() fail")
    void getWell_Fail() {
        assertThrows(FeignException.class, () -> {
            wellService.getWell(PROJECT_EXISTS, UWI_DENY);
        });
    }

    @Test
    @DisplayName("getWells() success")
    void getWells_Success() {
        assertNotNull(wellService.getWells(PROJECT_EXISTS));
    }
}