package com.cloud.kitchen.Auth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.kitchen.Auth.configuration.JwtTokenProvider;
import com.cloud.kitchen.Auth.model.User;
import com.cloud.kitchen.Auth.request.LoginRequest;
import com.cloud.kitchen.Auth.request.RegistrationRequest;
import com.cloud.kitchen.Auth.response.LoginResponse;
import com.cloud.kitchen.Auth.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

@PostMapping("/login")
public ResponseEntity<?> loginUser(@RequestBody @Valid LoginRequest loginRequest) {
    Optional<User> userOptional = userService.getUser(loginRequest.getEmail());
    if (userOptional.isEmpty()) {
        return ResponseEntity.badRequest().body("Invalid username or password");
    }

    User user = userOptional.get();
    if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
        return ResponseEntity.badRequest().body("Invalid username or password");
    }

    // Generate JWT token
    String token = jwtTokenProvider.generateToken(user);
    return ResponseEntity.ok(new LoginResponse(token,user));
}



 @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        // Check if username/email is already taken
        if (userService.getUser(registrationRequest.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        // Create a new user
        User user = new User();
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        userService.registerUser(user);

        return ResponseEntity.ok("User registered successfully");
    }


 @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        
        request.getSession().invalidate();

        SecurityContextHolder.clearContext();

        return ResponseEntity.ok("Logout successful");
    }


    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }
    
}
