package com.example.apporder.persistenceapi.service.impl;

import com.example.apporder.model.Product;
import com.example.apporder.persistenceapi.repository.ProductRepository;
import com.example.apporder.persistenceapi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Cacheable("products")
    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found by id: " + productId));
    }

    public Product save(Product product) {
       return productRepository.save(product);
    }
}
