package com.prosoft.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {
    private final String userName;
    private final String password;

    public FeignClientConfiguration(@Value("${geoeditor.well-service.username}") String userName,
                                    @Value("${geoeditor.well-service.password}") String password) {
        this.userName = userName;
        this.password = password;

    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(userName, password);
    }

}
