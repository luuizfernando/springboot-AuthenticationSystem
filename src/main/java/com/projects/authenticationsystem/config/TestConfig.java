package com.projects.authenticationsystem.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projects.authenticationsystem.entities.User;
import com.projects.authenticationsystem.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Luiz", "luiz@gmail.com", "luiz123", Instant.parse("2025-06-17T12:56:00Z"), null);
		User u2 = new User(null, "Isabella", "isabella@gmail.com", "isa123", Instant.parse("2025-06-17T13:00:00Z"), null);
		userRepository.saveAll(Arrays.asList(u1, u2));
	}	
}