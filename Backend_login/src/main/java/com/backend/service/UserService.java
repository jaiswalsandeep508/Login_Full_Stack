package com.backend.service;

import com.backend.model.Users;

public interface UserService {
	Boolean registerUser(Users user);
	Users authenticateUser(String userName, String password);
}
