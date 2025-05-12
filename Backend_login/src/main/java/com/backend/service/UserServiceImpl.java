package com.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Users;
import com.backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public Boolean registerUser(Users user) {
	    Optional<Users> existingUser = userRepo.findByUserName(user.getUserName());
	    if (existingUser.isPresent()) {
	       return false; // Handle duplicate case
	    }
	    userRepo.save(user);
	    return true;
	}
	
	@Override
	public Users authenticateUser(String userName, String password) {
	    Optional<Users> existingUser = userRepo.findByUserName(userName);

	    if (existingUser.isPresent()) {
	        Users user = existingUser.get(); // Extract actual user object
	        if (user.getPassword().equals(password)) {
	            return user; // Authentication successful
	        }
	    }
	    return null; // User not found or password incorrect
	}
	

}
