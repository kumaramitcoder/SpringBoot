package com.example.springbootexample.serviceImpl;

import com.example.springbootexample.entity.Product;
import com.example.springbootexample.entity.ProductDTORequest;
import com.example.springbootexample.entity.ProductDTOResponse;
import com.example.springbootexample.exception.ProductNotFoundException;
import com.example.springbootexample.repository.ProductRepository;
import com.example.springbootexample.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }


    @Override
    public ResponseEntity<List<ProductDTOResponse>> findAllProduct() {
        List<Product> list = productRepository.findAll();
        List<ProductDTOResponse> updatedList = list.stream()
                .map(e-> new ProductDTOResponse(e.getId(), e.getName(), e.getDescription()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(updatedList);
    }

    @Override
    public ResponseEntity<ProductDTOResponse> findByIdProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("PRoduct Not Found with id: "+id));
        ProductDTOResponse productDTOResponse = new ProductDTOResponse(product.getId(), product.getName(), product.getDescription());
        return ResponseEntity.status(HttpStatus.OK).body(productDTOResponse);
    }

    @Override
    public ResponseEntity<ProductDTOResponse> createProduct(ProductDTORequest productDTORequest) {
        Product product = new Product();
        product.setId(productDTORequest.getId());
        product.setName(productDTORequest.getName());
        product.setDescription(productDTORequest.getDescription());
        product.setPrice(productDTORequest.getPrice());

        Product updatedProduct = productRepository.save(product);

        ProductDTOResponse productDTOResponse = new ProductDTOResponse(updatedProduct.getId(), updatedProduct.getName(), updatedProduct.getDescription());

        return ResponseEntity.status(HttpStatus.CREATED).body(productDTOResponse);
    }

    @Override
    public ResponseEntity<ProductDTOResponse> updateProduct(Integer id, ProductDTORequest productDTORequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Not get by id"+id));

        product.setName(productDTORequest.getName());
        product.setDescription(productDTORequest.getDescription());
        product.setPrice(productDTORequest.getPrice());

        Product updtaeproduct = productRepository.save(product);

        ProductDTOResponse productDTOResponse = new ProductDTOResponse(updtaeproduct.getId(), updtaeproduct.getName(), updtaeproduct.getDescription());

        return ResponseEntity.status(HttpStatus.OK).body(productDTOResponse);

    }

    @Override
    public ResponseEntity<Void> deleteProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Id not found : "+id));
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
