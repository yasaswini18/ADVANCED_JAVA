package com.onlineCourseManagementSystem.Dtos;

import lombok.*;
import jakarta.validation.constraints.*;
import com.onlineCourseManagementSystem.entity.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDTO {

    @NotBlank
    private String fullName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private Role role;

}