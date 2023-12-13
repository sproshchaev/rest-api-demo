package com.prosoft.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(customizer -> customizer
                        .antMatchers("/wells/{project}/100").denyAll()
                        .antMatchers("/wells/{project}/101").permitAll()
                        .antMatchers("/wells/{project}").permitAll()
                        .antMatchers("/wells/{project}/102").authenticated()
                        .anyRequest().denyAll())
                .exceptionHandling(customizer -> customizer
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .build();
    }
        /*
        http
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/wells/{project}/100").denyAll()
                        .antMatchers("/wells/{project}/101").authenticated()
                )
                .formLogin();
        return http.build();
    }
*/

/*
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        // InMemoryUserDetailsManager (see below)
        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder().encode("user1Pass"))
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder().encode("user2Pass"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("adminPass"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }
*/

/*
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        var i = 100;
        http
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .antMatchers("/wells/{project}/" + i).denyAll()
                        .antMatchers("/wells/{project}/" + i + 1).permitAll()

                );
        return http.build();
    }
*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        var encoder = new BCryptPasswordEncoder();
        var password = encoder.encode("remote");
        System.out.println(password);
        return new BCryptPasswordEncoder();
    }

/*
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests  // 29:35 https://vk.com/public218833461?w=wall-218833461_148
                                .requestMatchers("").permitAll() // - разрешить всем, если GET и любое после wells/
                        // .requestMatchers("localhost:8081/wells/").denyAll() // - запретить всем
                        // .requestMatchers("localhost:8081/wells/").anonymous() //- только анонимным пользователям (не аутонтифицированные)
                        // .requestMatchers("localhost:8081/wells/").authenticated() // - только аутентифицированные пользователи
                        // .requestMatchers("localhost:8081/wells/").rememberMe() // - долгоживущие сессии (запомнить меня)
                        // .requestMatchers("localhost:8081/wells/").fullyAuthenticated // - полностью авторизованные (не из .rememberMe)
                        // .requestMatchers("localhost:8081/wells/").hasAuthority("view") // - только пользователи с правом "view"
                        // .requestMatchers("localhost:8081/wells/").hasAnyAuthority("update", "delete") // - любой пользователь, который имеет любое из указанных прав ("update" или "delete")
                        // .requestMatchers("localhost:8081/wells/").hasRole("admin") // - только пользователь с ролью "admin"
                        // .requestMatchers("localhost:8081/wells/").hasAnyRole("customer", "manager") // - пользователь, имеющий одну из ролей "customer" или "manager"
                        // .requestMatchers("localhost:8081/wells/").access() // принимает лябду, в которой можно определить правило доступа
                )
                .build();

    }
*/
/*
        // стандартные настройки цепочки безопасности
        return http
                // разрешить доступ только для аутентифицированных пользователей
                .authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
                // включить поддержку формы входа
                .formLogin(withDefaults())
                // включить поддержку Basic-аутентификации
                .httpBasic(withDefaults())
                // собрать цепочку фильтров
                .build();
*/


}
