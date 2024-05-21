package com.cloud.kitchen.exception.custom_exception;

public class ResourceStorageFailedException extends RuntimeException{
    
    public ResourceStorageFailedException(String message){
        super(message);
       
    }
}
