package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.model.User;
import com.mvc.repository.UserRepository;
@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	@Override
	public User getUserById(Long id)
	{
		return userRepository.findById(id);
	}
	
	@Override
	public void addUser(User user)
	{
		userRepository.save(user);
	}

}
