package com.arcana.BookStoreRestApi.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.arcana.BookStoreRestApi.dto.LoginResponse;
import com.arcana.BookStoreRestApi.dto.PageResponse;
import com.arcana.BookStoreRestApi.dto.UserDto;
import com.arcana.BookStoreRestApi.entity.User;
import com.arcana.BookStoreRestApi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public String registerUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return "Registered Successfully";
    }

    public LoginResponse loginUser(String username, String password) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(user.getPassword().equals(password)) {

            String accessToken = "access-token-" + user.getUsername(); // placeholder
            String refreshToken = "access-token-"+user.getUsername();
            return new LoginResponse(
                    "Login Successful",
                    user.getUsername(),
                    accessToken,
                    refreshToken
            );
        }

        throw new RuntimeException("Invalid Credentials");
    }

    public UserDto getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
    }

    public String updateUser(Long id, UserDto userDto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        userRepository.save(user);
        return "User Updated Successfully";
    }

    public String deleteUser(Long id){
        userRepository.deleteById(id);
        return "User Deleted Successfully";
    }

    public PageResponse<UserDto> getUsers(int page, int size, String sortBy, String direction){

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<User> userPage = userRepository.findAll(pageable);

        List<UserDto> userDtos = userPage.getContent()
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();

        return new PageResponse<>(
                userDtos,
                userPage.getNumber(),
                userPage.getSize(),
                userPage.getTotalElements(),
                userPage.getTotalPages()
        );
    }
}