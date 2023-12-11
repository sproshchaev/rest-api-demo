package com.prosoft.repository;

import com.prosoft.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByLogin(String login);
}
