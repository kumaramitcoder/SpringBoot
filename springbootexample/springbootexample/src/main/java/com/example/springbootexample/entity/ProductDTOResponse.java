package com.example.springbootexample.entity;

import lombok.Data;

@Data
public class ProductDTOResponse {
    private int id;
    private String name;
    private String description;

    public ProductDTOResponse(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
