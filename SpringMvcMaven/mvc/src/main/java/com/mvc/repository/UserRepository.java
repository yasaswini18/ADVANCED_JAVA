package com.mvc.repository;

import java.util.List;

import com.mvc.model.User;

public interface UserRepository {
	List<User> findAll();
	User findById(Long id);
	void save(User user);
}
