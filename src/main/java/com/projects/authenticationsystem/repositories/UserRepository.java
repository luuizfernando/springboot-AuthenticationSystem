package com.projects.authenticationsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.authenticationsystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {}