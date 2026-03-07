package com.BookSecurity.Service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BookSecurity.DTO.AuthResponse;
import com.BookSecurity.DTO.LoginRequest;
import com.BookSecurity.DTO.RegisterRequest;
import com.BookSecurity.Entity.Role;
import com.BookSecurity.Entity.User;
import com.BookSecurity.Repository.UserRepository;
import com.BookSecurity.Security.JwtUtil;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuthService {
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	public String register(RegisterRequest request)
	{
		User user = modelMapper.map(request, User.class);
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(Role.valueOf(request.getRole()));
		
		userRepository.save(user);
		return "User registered successfully";
	}
	
	public AuthResponse login(LoginRequest request)
	{
		User user = userRepository.findByUsername(request.getUsername())
				.orElseThrow(()->new RuntimeException("User not found"));
		
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
		{
			throw new RuntimeException("Invalid Credentials");
		}
		String token = jwtUtil.generateToken(user.getUsername(), user.getRole().name());
		return new AuthResponse(token,user.getUsername(),user.getRole().name());
	}
}
