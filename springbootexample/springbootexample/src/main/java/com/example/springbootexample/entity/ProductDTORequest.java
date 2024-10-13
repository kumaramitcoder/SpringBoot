package com.example.springbootexample.entity;

import lombok.Data;

@Data
public class ProductDTORequest {
    private int id;
    private String name;
    private String description;
    private Double price;


    public ProductDTORequest(Product product){
        this.id=product.getId();
        this.name=product.getName();
        this.description=product.getDescription();
        this.price=product.getPrice();
    }

    public ProductDTORequest() {
    }

    public ProductDTORequest(int id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price=price;
    }
}
