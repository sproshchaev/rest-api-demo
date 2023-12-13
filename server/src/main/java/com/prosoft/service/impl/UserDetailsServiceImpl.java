package com.prosoft.service.impl;

import com.prosoft.domain.User;
import com.prosoft.repository.UserRepository;
import com.prosoft.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final SchemaService schemaService;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, SchemaService schemaService) {
        this.userRepository = userRepository;
        this.schemaService = schemaService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        if (schemaService.setCurrSchema(new String[]{"test_project"})) {
            return userRepository.findByLogin(login)
                    .orElseThrow(() -> new UsernameNotFoundException("Username " + login + " not found"));
        } else {
            return null;
        }
    }
}
