package com.example.apporder.mainapi.service;

import com.example.apporder.model.Product;

public interface ProductRequestService {
    Product getProduct(Long productId);
}
