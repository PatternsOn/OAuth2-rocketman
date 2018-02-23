package com.patternson.oauth2rocketman;

import com.patternson.oauth2rocketman.config.CustomUserDetails;
import com.patternson.oauth2rocketman.entities.Role;
import com.patternson.oauth2rocketman.entities.User;
import com.patternson.oauth2rocketman.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import java.util.Arrays;

@SpringBootApplication
public class Oauth2RocketmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2RocketmanApplication.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {

		if(repo.count() == 0) {
			repo.save(new User("user", "user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		}
		builder.userDetailsService(username -> new CustomUserDetails(repo.findByUsername(username)));
	}
}
