package com.mvc.service;

import java.util.List;

import com.mvc.model.User;

public interface UserService {
	List<User> getAllUsers();
	User getUserById(Long id);
	void addUser(User user);
}
