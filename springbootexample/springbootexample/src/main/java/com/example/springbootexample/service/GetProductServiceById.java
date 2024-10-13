package com.example.springbootexample.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springbootexample.entity.Product;
import com.example.springbootexample.entity.ProductDTO;
import com.example.springbootexample.repository.ProductRepository;

@Service
public class GetProductServiceById implements Query<Integer, ProductDTO> {

	private final ProductRepository productRepository;
	
	public GetProductServiceById(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public ResponseEntity<ProductDTO> execute(Integer input) {
		// TODO Auto-generated method stub
		Optional<Product> productOptional = productRepository.findById(input);
		if(productOptional.isPresent()) {
			return ResponseEntity.ok(new ProductDTO(productOptional.get()));
		}
 		return null;
	}
	
	
	
	

}
