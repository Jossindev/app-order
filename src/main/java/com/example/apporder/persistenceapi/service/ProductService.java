package com.example.apporder.persistenceapi.service;

import com.example.apporder.model.Product;

public interface ProductService {
    Product getProduct(Long productId);

    Product save(Product product);
}
