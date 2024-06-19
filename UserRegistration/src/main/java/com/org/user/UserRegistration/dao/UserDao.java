package com.org.user.UserRegistration.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.user.UserRegistration.cException.EmailAlreadyExistsException;
import com.org.user.UserRegistration.cException.ResourceNotFoundException;
import com.org.user.UserRegistration.dto.User;
import com.org.user.UserRegistration.repo.UserRepository;

@Component
public class UserDao {

	@Autowired
	UserRepository repo;

	public void saveUser(User user) {
		if (repo.findByEmail(user.getEmail()).isPresent()) {
			throw new EmailAlreadyExistsException("Email already exists: " + user.getEmail());
		}
		repo.save(user);
	}

	public Optional<User> fetchById(int id) {
		return repo.findById(id);
	}

	public List<User> FetchAll() {

		List<User> list = repo.findAll();

		return list;
	}
	
	public Optional<User> fetchUserByUsername(String username) {
		return repo.findByUsername(username);
	}
	
	

}
