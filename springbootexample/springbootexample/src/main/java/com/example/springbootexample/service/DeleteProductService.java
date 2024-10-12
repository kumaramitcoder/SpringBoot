package com.example.springbootexample.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springbootexample.entity.Product;
import com.example.springbootexample.repository.ProductRepository;

@Service
public class DeleteProductService implements Command<Integer, Void> {
	
	private final ProductRepository productRepository;
	
	public DeleteProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	@Override
	public ResponseEntity<Void> execute(Integer id) {
		// TODO Auto-generated method stub
		Optional<Product> productOptional = productRepository.findById(id);
		if(productOptional.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return null;
	}

	
}
