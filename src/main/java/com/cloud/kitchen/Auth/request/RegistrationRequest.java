package com.cloud.kitchen.Auth.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationRequest {

    @NotBlank(message = "firstName is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String firstName;
    @NotBlank(message = "lastName is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    private String password;

    // Getters and setters
}