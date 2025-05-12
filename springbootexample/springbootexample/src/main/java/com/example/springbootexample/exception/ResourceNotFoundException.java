package com.example.springbootexample.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg){
        super((msg));
    }
}
