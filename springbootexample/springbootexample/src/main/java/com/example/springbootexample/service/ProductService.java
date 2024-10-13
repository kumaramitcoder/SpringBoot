package com.example.springbootexample.service;

import com.example.springbootexample.entity.Product;
import com.example.springbootexample.entity.ProductDTORequest;
import com.example.springbootexample.entity.ProductDTOResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<List<ProductDTOResponse>> getAllProducts();

    ResponseEntity<ProductDTOResponse> getProductById(int id);

    ResponseEntity<ProductDTOResponse> createProduct(ProductDTORequest productDTORequest);


    ResponseEntity<ProductDTOResponse> updateProduct(int id, ProductDTORequest productDTORequest);

    ResponseEntity<Void> deleteProduct(int id);


}
