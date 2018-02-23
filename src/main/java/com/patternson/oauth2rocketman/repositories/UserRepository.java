package com.patternson.oauth2rocketman.repositories;

import com.patternson.oauth2rocketman.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
