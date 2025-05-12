package com.example.springbootexample.service;

import com.example.springbootexample.entity.Product;
import com.example.springbootexample.entity.ProductDTORequest;
import com.example.springbootexample.entity.ProductDTOResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    public ResponseEntity<List<ProductDTOResponse>> findAllProduct();

    public ResponseEntity<ProductDTOResponse> findByIdProduct(Integer id);

    public ResponseEntity<ProductDTOResponse> createProduct(ProductDTORequest productDTORequest);

    public ResponseEntity<ProductDTOResponse> updateProduct(Integer id, ProductDTORequest productDTORequest);

    public ResponseEntity<Void> deleteProduct(Integer id);

}
