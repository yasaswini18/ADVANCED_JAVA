package com.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvc.model.User;
@Repository
public class UserRepositoryImplementation implements UserRepository{
	private List<User> users = new ArrayList<>();
	public UserRepositoryImplementation()
	{
		users.add(new User(1L,"John Doe","john@example.com"));
		users.add(new User(2L,"Jane Smith","jane@example.com"));
	}
	@Override
	public List<User> findAll()
	{
		return users;
	}
	@Override
	public User findById(Long id)
	{
	return	users.stream().filter(u->u.getId().equals(id)).findFirst().orElse(null);
	}
	@Override
	public void save(User user)
	{
		users.add(user);
	}
	
}
