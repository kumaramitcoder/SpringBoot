package com.example.springbootexample.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springbootexample.entity.Product;
import com.example.springbootexample.entity.ProductDTO;
import com.example.springbootexample.entity.UpdatedProductCommand;
import com.example.springbootexample.exception.ProductNotFoundException;
import com.example.springbootexample.repository.ProductRepository;

@Service
public class UpdateProductService implements Command<UpdatedProductCommand , ProductDTO> {
	

	private ProductRepository productRepository;
	
	public UpdateProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	@Override
	public ResponseEntity<ProductDTO> execute(UpdatedProductCommand updatedProductCommand) {
		// TODO Auto-generated method stub
		Optional<Product> productOptional = productRepository.findById(updatedProductCommand.getId());
		if(productOptional.isPresent()) {
			Product product = updatedProductCommand.getProduct();
			product.setId(updatedProductCommand.getId());
			productRepository.save(product);
			return ResponseEntity.ok(new ProductDTO(product));
		}
		throw new ProductNotFoundException();
	}
}
