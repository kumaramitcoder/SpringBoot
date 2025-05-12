package com.example.springbootexample.entity;

import lombok.Data;

@Data
public class EmployeeDTORequest {
    private int id;
    private String name;
    private String email;

    public EmployeeDTORequest(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
