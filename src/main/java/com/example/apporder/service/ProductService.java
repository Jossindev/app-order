package com.example.apporder.service;

import com.example.apporder.model.Product;
import com.example.apporder.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Cacheable("orders")
    public Product getOneProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found by id: " + productId)); // add text to properties
    }
}
