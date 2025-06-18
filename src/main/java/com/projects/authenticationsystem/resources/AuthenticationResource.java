package com.projects.authenticationsystem.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.authenticationsystem.entities.AuthenticationDTO;
import com.projects.authenticationsystem.entities.RegisterDTO;
import com.projects.authenticationsystem.entities.User;
import com.projects.authenticationsystem.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;


@RestController
@RequestMapping("auth")
public class AuthenticationResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;
    
        @PostMapping("/login")
        public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);
    
    
            return ResponseEntity.ok().build();
        }
    
        @PostMapping("/register")
        public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
            if (this.userRepository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();
    
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            User newUser = new User(data.username(), data.email(), encryptedPassword, data.role());

        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}