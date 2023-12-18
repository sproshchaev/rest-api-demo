package com.prosoft.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers(HttpMethod.GET, "/wells/{project}/100").denyAll()
                        .antMatchers(HttpMethod.GET, "/wells/{project}/101").permitAll()
                        .antMatchers(HttpMethod.GET, "/wells/{project}").permitAll()
                        .antMatchers(HttpMethod.GET, "/wells/{project}/102").hasRole("remote")
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        var encoder = new BCryptPasswordEncoder();
        var password = encoder.encode("remote");
        System.out.println(password);
        return new BCryptPasswordEncoder();
    }

}
