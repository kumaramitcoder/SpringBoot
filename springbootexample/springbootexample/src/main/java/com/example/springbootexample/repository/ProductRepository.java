package com.example.springbootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootexample.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	
}
