package com.example.springbootexample.service;

import com.example.springbootexample.entity.Product;
import com.example.springbootexample.entity.ProductDTORequest;
import com.example.springbootexample.entity.ProductDTOResponse;
import com.example.springbootexample.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTOResponse>> getAllProducts() {
        List<Product> listofproduct = productRepository.findAll();
        List<ProductDTOResponse> productDTOResponseList = listofproduct.stream()
                .map(e-> new ProductDTOResponse(e.getId(), e.getName(), e.getDescription()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(productDTOResponseList);
    }

    @Override
    public ResponseEntity<ProductDTOResponse> getProductById(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            ProductDTOResponse productDTOResponse = new ProductDTOResponse(product.getId(),product.getName(),product.getDescription());
            return ResponseEntity.status(HttpStatus.OK).body(productDTOResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    public ResponseEntity<ProductDTOResponse> createProduct(ProductDTORequest productDTORequest) {

        Product product = new Product();
        product.setName(productDTORequest.getName());
        product.setDescription(productDTORequest.getDescription());
        product.setPrice(productDTORequest.getPrice());

        Product updateProduct = productRepository.save(product);

        ProductDTOResponse productDTOResponse = new ProductDTOResponse(updateProduct.getId(), updateProduct.getName(), updateProduct.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTOResponse);
    }


    @Override
    public ResponseEntity<ProductDTOResponse> updateProduct(int id, ProductDTORequest productDTORequest) {
        Optional<Product> existProduct = productRepository.findById(id);
        if (existProduct.isPresent()){
            Product product = existProduct.get();
            product.setName(productDTORequest.getName());
            product.setDescription(productDTORequest.getDescription());

            Product updateProduct = productRepository.save(product);
            ProductDTOResponse productDTOResponse = new ProductDTOResponse(updateProduct.getId(), updateProduct.getName(), updateProduct.getDescription());
            return ResponseEntity.status(HttpStatus.OK).body(productDTOResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    public ResponseEntity<Void> deleteProduct(int id) {
        Optional<Product> existProduct = productRepository.findById(id);
        if (existProduct.isPresent()){
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
