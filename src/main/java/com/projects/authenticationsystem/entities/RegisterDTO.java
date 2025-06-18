package com.projects.authenticationsystem.entities;

import com.projects.authenticationsystem.entities.enums.UserRole;

public record RegisterDTO(String username, String email, String password, UserRole role) {
}