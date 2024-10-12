package com.example.springbootexample.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springbootexample.entity.Product;
import com.example.springbootexample.entity.ProductDTO;
import com.example.springbootexample.repository.ProductRepository;

@Service
public class CreateProductService implements Command<Product, ProductDTO>{

	private final ProductRepository productRepository;
	
	
	

	public CreateProductService(ProductRepository productRepository) {
			this.productRepository = productRepository;
	}




	@Override
	public ResponseEntity<ProductDTO> execute(Product product) {
		// TODO Auto-generated method stub
		Product saveProduct = productRepository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(saveProduct));
	}
	
}
