package com.onlineCourseManagementSystem.controller;

import com.onlineCourseManagementSystem.Dtos.LoginRequestDTO;
import com.onlineCourseManagementSystem.Dtos.RegisterRequestDTO;
import com.onlineCourseManagementSystem.Dtos.UserResponseDTO;
import com.onlineCourseManagementSystem.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponseDTO register(@Valid@RequestBody RegisterRequestDTO request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public UserResponseDTO login(@Valid@RequestBody LoginRequestDTO request) {
        return userService.loginUser(request);
    }
}