package com.example.springbootexample.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String name){
        super(name);
    }
}
