package com.arcana.BookStoreRestApi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arcana.BookStoreRestApi.dto.*;
import com.arcana.BookStoreRestApi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User", description = "User Management APIs")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(
            summary = "Register A New User",
            description = "Registers a new User in the system"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registered Successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<String> register(@Valid @RequestBody UserDto userDto) {

        return ResponseEntity.ok(userService.registerUser(userDto));
    }

    @PostMapping("/login")
    @Operation(
            summary = "Login the registered User",
            description = "Logs the user into the system"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Logged In Successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid Credentials")
    })
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    ) {

        LoginResponse response =
                userService.loginUser(request.getUsername(), request.getPassword());

        return ResponseEntity.ok(response);
    }
    
    

    @GetMapping("/getUser/{id}")
    @Operation(summary = "Gets user as per their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid ID")
    })
    public ResponseEntity<UserDto> findById(@PathVariable Long id){

        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDto>> findAll(){

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(
            @PathVariable Long id,
            @Valid @RequestBody UserDto userDto){

        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    @GetMapping("/page")
    public ResponseEntity<PageResponse<UserDto>> getUsers(

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {

        return ResponseEntity.ok(
                userService.getUsers(page, size, sortBy, direction)
        );
    }
}