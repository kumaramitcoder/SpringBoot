package com.example.springbootexample.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String customerName;
    private String  product;

    private Integer quantity;

    private double price;





}
