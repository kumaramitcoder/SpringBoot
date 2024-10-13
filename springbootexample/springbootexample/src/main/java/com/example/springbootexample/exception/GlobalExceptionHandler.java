package com.example.springbootexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundEx(ProductNotFoundException px, WebRequest webRequest){
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp" , LocalDateTime.now());
        map.put("message", px.getMessage());
        map.put("details", webRequest.getDescription(false));

        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalEx(Exception ex , WebRequest webRequest){
        Map<String , Object> map = new HashMap<>();
        map.put("timestamp" , LocalDateTime.now());
        map.put("message", ex.getMessage());
        map.put("details", webRequest.getDescription(false));

        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR );
    }

}
