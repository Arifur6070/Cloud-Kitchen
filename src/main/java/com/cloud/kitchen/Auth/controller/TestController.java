package com.cloud.kitchen.Auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class TestController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }
    
    
    
}
