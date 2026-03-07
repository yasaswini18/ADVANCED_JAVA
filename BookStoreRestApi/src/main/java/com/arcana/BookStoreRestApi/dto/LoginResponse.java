package com.arcana.BookStoreRestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private String message;
    private String username;
    private String accessToken;
    private String refreshToken;
}