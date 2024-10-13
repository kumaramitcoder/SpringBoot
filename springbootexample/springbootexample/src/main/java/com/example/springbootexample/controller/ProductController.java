package com.example.springbootexample.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springbootexample.entity.Product;
import com.example.springbootexample.entity.ProductDTO;
import com.example.springbootexample.entity.UpdatedProductCommand;
import com.example.springbootexample.service.CreateProductService;
import com.example.springbootexample.service.DeleteProductService;
import com.example.springbootexample.service.GetProductService;
import com.example.springbootexample.service.GetProductServiceById;
import com.example.springbootexample.service.UpdateProductService;

@RestController
public class ProductController {
	
	private final CreateProductService createProductService;
	private final GetProductService getProductService;
	private final UpdateProductService updateProductService;
	private final DeleteProductService deleteProductService;
	private final GetProductServiceById getProductServiceById;
	
	public ProductController(GetProductServiceById getProductServiceById,CreateProductService createProductService, GetProductService getProductService, UpdateProductService updateProductService, DeleteProductService deleteProductService) {
		this.createProductService= createProductService;
		this.getProductService = getProductService;
		this.updateProductService=updateProductService;
		this.deleteProductService=deleteProductService;
		this.getProductServiceById=getProductServiceById;
	}
	
	@PostMapping("/product")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product){
		return createProductService.execute(product);
	}
	@CrossOrigin(origins = "http://localhost:3000",methods = RequestMethod.GET)
	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getProduct(){
		return getProductService.execute(null);
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
		return getProductById(id);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product){
		return updateProductService.execute(new UpdatedProductCommand(id, product));
	}
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
		return deleteProductService.execute(id);
	}
	
}
