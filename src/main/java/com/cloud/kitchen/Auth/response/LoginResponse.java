package com.cloud.kitchen.Auth.response;

import com.cloud.kitchen.Auth.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private User user;

    public LoginResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    // Getters and setters
    // ...
}