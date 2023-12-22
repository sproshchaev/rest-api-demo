package com.prosoft.service.impl;

import com.prosoft.domain.Well;
import com.prosoft.dto.User;
import com.prosoft.feign.PostmanProxy;
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
    private final static long UWI_DENY = 100L;
    private final static long UWI_PERMIT = 101L;
    private final static long UWI_AUTH = 102L;

    @Autowired
    private WellService wellService;

    @Autowired
    private PostmanProxy postmanProxy;

    @Test
    @DisplayName("getWell() success")
    void getWell_Success_Test() {
        Well well = wellService.getWell(PROJECT_EXISTS, UWI_PERMIT);
        log.info("getWell(" + PROJECT_EXISTS + "," + UWI_PERMIT + ")=" + well.toString());
        assertNotNull(well);
    }

    @Test
    @DisplayName("getWell() fail")
    void getWell_Fail_Test() {
        assertThrows(FeignException.class, () -> {
            wellService.getWell(PROJECT_EXISTS, UWI_DENY);
        });
    }

    @Test
    @DisplayName("getWells() list success")
    void getWells_Success_Test() {
        assertNotNull(wellService.getWells(PROJECT_EXISTS));
    }

    @Test
    @DisplayName("getWell() auth success 'remote'")
    void getWell_AuthSuccess_Test() {
        Well well = wellService.getWell(PROJECT_EXISTS, UWI_AUTH);
        log.info("getWell(" + PROJECT_EXISTS + "," + UWI_PERMIT + ")=" + well.toString());
        assertNotNull(well);
    }

    @Test
    @DisplayName("postman")
    void getToken_Test() {
        postmanProxy.getToken(new User("user1", "pass1"));
    }


}