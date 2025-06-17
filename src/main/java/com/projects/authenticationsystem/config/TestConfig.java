package com.projects.authenticationsystem.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projects.authenticationsystem.entities.User;
import com.projects.authenticationsystem.entities.enums.UserRole;
import com.projects.authenticationsystem.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Luiz", "luiz@gmail.com", "luiz123", UserRole.USER);
		User u2 = new User(null, "Isabella", "isabella@gmail.com", "isa123", UserRole.USER);
		User u3 = new User(null, "Carmem", "carmem@gmail.com", "carmem123", UserRole.USER);
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}	
}