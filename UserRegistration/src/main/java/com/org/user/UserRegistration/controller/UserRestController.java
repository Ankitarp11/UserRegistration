package com.org.user.UserRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.user.UserRegistration.dao.UserDao;
import com.org.user.UserRegistration.dto.User;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	UserDao dao;
	
	@PostMapping("/register")
	public void registerUser(@RequestBody User user) {
		dao.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> fetchUserById(@PathVariable int id) {
		User user = dao.fetchById(id);
		
		return ResponseEntity.ok(user);
	}
	
	
}
