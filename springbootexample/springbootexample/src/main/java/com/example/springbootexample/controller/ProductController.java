package com.example.springbootexample.controller;


import com.example.springbootexample.entity.ProductDTORequest;
import com.example.springbootexample.entity.ProductDTOResponse;
import com.example.springbootexample.service.ProductServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    private final ProductServiceImp productServiceImp;

    public  ProductController(ProductServiceImp productServiceImp){
        this.productServiceImp=productServiceImp;
    }
    @GetMapping("/products")
   public ResponseEntity<List<ProductDTOResponse>> getAll(){
        return productServiceImp.getAllProducts();
   }
    @GetMapping("/products/{id}")
   public ResponseEntity<ProductDTOResponse> getById(@PathVariable int id){
        return productServiceImp.getProductById(id);
   }

   @PostMapping("/product")
   public ResponseEntity<ProductDTOResponse> createProduct(@RequestBody ProductDTORequest productDTORequest){
        return productServiceImp.createProduct(productDTORequest);
   }

   @PutMapping("/product/{id}")
   public ResponseEntity<ProductDTOResponse> updateProduct(@PathVariable int id, @RequestBody ProductDTORequest productDTORequest){
        return productServiceImp.updateProduct(id, productDTORequest);
   }

   @DeleteMapping("/product/{id}")
   public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        return productServiceImp.deleteProduct(id);
   }




}
