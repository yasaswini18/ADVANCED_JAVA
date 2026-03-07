package com.onlineCourseManagementSystem.controller;

import com.onlineCourseManagementSystem.Dtos.UserResponseDTO;
import com.onlineCourseManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable Long id) {
        return userService.getUserProfile(id);
    }
}