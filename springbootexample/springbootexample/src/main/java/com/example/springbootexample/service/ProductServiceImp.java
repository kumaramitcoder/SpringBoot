package com.example.springbootexample.service;

import com.example.springbootexample.entity.Product;
import com.example.springbootexample.entity.ProductDTORequest;
import com.example.springbootexample.entity.ProductDTOResponse;
import com.example.springbootexample.exception.ProductNotFoundException;
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
      Product product = productRepository.findById(id)
              .orElseThrow(()->new ProductNotFoundException("Book not Found with Id "+id));
      ProductDTOResponse productDTOResponse = new ProductDTOResponse(product.getId(), product.getName(), product.getDescription());
      return ResponseEntity.status(HttpStatus.OK).body(productDTOResponse);
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
        Product product = productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product not found with id : "+id));
        product.setName(productDTORequest.getName());
        product.setDescription(productDTORequest.getDescription());

        Product updateProduct = productRepository.save(product);
        ProductDTOResponse productDTOResponse = new ProductDTOResponse(updateProduct.getId(), updateProduct.getName(), updateProduct.getDescription());

        return ResponseEntity.status(HttpStatus.OK).body(productDTOResponse);

    }

    @Override
    public ResponseEntity<Void> deleteProduct(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product not found with id : "+id));
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
