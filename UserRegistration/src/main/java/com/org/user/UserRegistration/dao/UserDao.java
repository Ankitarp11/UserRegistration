package com.org.user.UserRegistration.dao;

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
        if (repo.FindByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists: " + user.getEmail());
        }
        repo.save(user);
    }
	
	public User fetchById(int id) {
		User user = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("This id is doesn't exist "+id));
		
		return user;
			
	}

}
