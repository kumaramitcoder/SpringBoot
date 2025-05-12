package com.example.springbootexample.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
}
