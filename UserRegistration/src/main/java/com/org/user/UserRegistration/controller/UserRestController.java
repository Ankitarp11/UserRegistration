package com.org.user.UserRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.user.UserRegistration.cException.ResourceNotFoundException;
import com.org.user.UserRegistration.dao.UserDao;
import com.org.user.UserRegistration.dto.User;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	UserDao dao;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		dao.saveUser(user);
		
		new ResponseEntity<User>(user,HttpStatus.CREATED);
		 return ResponseEntity.ok("User Registered successfully\n"+user);
	}

	@GetMapping("/fetchid/{id}")
	public ResponseEntity<User> fetchUserById(@PathVariable int id) {
		User user = dao.fetchById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return ResponseEntity.ok(user);
	}

	
	@GetMapping("/username/{username}")
	public ResponseEntity<User> fetchByUsername(@PathVariable String username){
		User user = dao.fetchUserByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
        return ResponseEntity.ok(user); 
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> fetchAllUsers() {
		List<User> list = dao.FetchAll();
		
		return ResponseEntity.ok(list);
	}

}
