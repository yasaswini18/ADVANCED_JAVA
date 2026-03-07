package com.onlineCourseManagementSystem.service;

import org.springframework.stereotype.Service;

import com.onlineCourseManagementSystem.Dtos.LoginRequestDTO;
import com.onlineCourseManagementSystem.Dtos.RegisterRequestDTO;
import com.onlineCourseManagementSystem.Dtos.UserResponseDTO;
@Service
public interface UserService {

    UserResponseDTO registerUser(RegisterRequestDTO request);

    UserResponseDTO loginUser(LoginRequestDTO request);

    UserResponseDTO getUserProfile(Long userId);

}