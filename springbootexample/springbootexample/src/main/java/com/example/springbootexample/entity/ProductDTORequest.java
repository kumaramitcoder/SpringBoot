package com.example.springbootexample.entity;

import lombok.Data;

@Data
public class ProductDTORequest {
    private int id;
    private String name;
    private String description;
    private Double price;


    public ProductDTORequest(int id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
