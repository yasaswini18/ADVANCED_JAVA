package com.libraryManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.libraryManagementSystem.model.User;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private long userCounter = 1;

    public void addUser(User user) {
        user.setId(userCounter++);
        users.add(user);
    }

    public boolean validateUser(String email, String password) {
        return users.stream()
                .anyMatch(u ->
                        u.getEmail().equals(email) &&
                        u.getPassword().equals(password));
    }
}
	

