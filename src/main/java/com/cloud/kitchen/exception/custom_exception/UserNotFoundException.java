package com.cloud.kitchen.exception.custom_exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
       
    }
    
}
