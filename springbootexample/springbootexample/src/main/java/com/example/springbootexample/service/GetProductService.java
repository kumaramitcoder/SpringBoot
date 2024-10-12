package com.example.springbootexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springbootexample.entity.Product;
import com.example.springbootexample.entity.ProductDTO;
import com.example.springbootexample.repository.ProductRepository;

@Service
public class GetProductService implements Query<Void, List<ProductDTO>> {
	
	private final ProductRepository productRepository;
	
	public GetProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ResponseEntity<List<ProductDTO>> execute(Void input) {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDTOs = products.stream().map(ProductDTO :: new).toList();
		return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
	}
}
