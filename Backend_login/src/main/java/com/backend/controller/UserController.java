package com.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Users;
import com.backend.service.UserService;


@RestController
@RequestMapping("/form")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	private ResponseEntity<String> registerUser(@RequestBody Users user) {	   
	   return userService.registerUser(user)? ResponseEntity.ok("User registered successfully") : ResponseEntity.badRequest().body("User already exists");
	}
	
	@PostMapping("/login")
	private ResponseEntity<String> login(@RequestBody Users user){
		Users authenticatedUser = userService.authenticateUser(user.getUserName(), user.getPassword());
		if(authenticatedUser != null) {
			return ResponseEntity.ok("Login Successfully..");
		}
		return ResponseEntity.status(401).body("Invalid Credentials");
	}
	
}
