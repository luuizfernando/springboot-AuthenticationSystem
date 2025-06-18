package com.projects.authenticationsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.projects.authenticationsystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String username);
}