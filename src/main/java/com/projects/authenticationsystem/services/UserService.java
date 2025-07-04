package com.projects.authenticationsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projects.authenticationsystem.entities.User;
import com.projects.authenticationsystem.repositories.UserRepository;
import com.projects.authenticationsystem.services.exceptions.DatabaseException;
import com.projects.authenticationsystem.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insertUser(User obj) {
		return repository.save(obj);
	}

	public User updateUser(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateUser(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateUser(User entity, User obj) {
		entity.setUsername(obj.getUsername());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
	}

	public void deleteUser(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}