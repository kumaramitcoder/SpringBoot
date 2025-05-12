package com.example.springbootexample.controller;


import com.example.springbootexample.entity.ProductDTORequest;
import com.example.springbootexample.entity.ProductDTOResponse;
import com.example.springbootexample.serviceImpl.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService){
        this.productService = productService;
    }
    @CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React app
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTOResponse>> getAllProducts(){
        return productService.findAllProduct();
    }

    @CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React app
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTOResponse> getProductById(@PathVariable Integer id){
        return productService.findByIdProduct(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React app
    @PostMapping("/product")
    public ResponseEntity<ProductDTOResponse> createProduct(@RequestBody ProductDTORequest productDTORequest){
       return productService.createProduct(productDTORequest);
    }
    @CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React app
    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTOResponse> updateProduct(@PathVariable Integer id, @RequestBody ProductDTORequest productDTORequest){
        return productService.updateProduct(id, productDTORequest);
    }
    @CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React app
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }

}
