package com.cloud.kitchen.Auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Registration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloud.kitchen.Auth.model.User;
import com.cloud.kitchen.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        userRepository.save(user);
    }


    public Optional<User> getUser(String email){

        Optional<User> user = userRepository.findByEmail(email);

        return user;

    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
}
