package com.arcana.BookStoreRestApi.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 5, message = "Password Should be of Min 5 Characters")
    private String password;

    @NotBlank(message = "Email Cannot be blank")
    private String email;
}