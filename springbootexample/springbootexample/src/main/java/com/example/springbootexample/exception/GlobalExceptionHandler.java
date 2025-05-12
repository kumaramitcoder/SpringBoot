package com.example.springbootexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException p, WebRequest w){
        Map<String, Object> map = new HashMap<>();
        map.put("timeStamp", LocalDateTime.now());
        map.put("message", p.getMessage());
        map.put("details", w.getDescription(false));

        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest w){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("timeStamp", LocalDateTime.now());
        map1.put("message", ex.getMessage());
        map1.put("details", w.getDescription(false));

        return new ResponseEntity<>(map1, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleResourceNotFound(ResourceNotFoundException rx,WebRequest webRequest){
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("status", HttpStatus.NOT_FOUND.value());
        errorBody.put("error", "Not Found");
        errorBody.put("message", rx.getMessage());
        errorBody.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

    public  ResponseEntity<String> handlegenericException(Exception ex){
        return  new ResponseEntity<>("Something went wrong "+ ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
