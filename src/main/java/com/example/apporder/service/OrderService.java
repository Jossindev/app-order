package com.example.apporder.service;

import com.example.apporder.model.Order;

public interface OrderService {
    Order save(Order order);

    void deleteById(Long orderId);

    Order addProduct(Long orderId, Long productId);

    Order deleteProduct(Long orderId, Long productId);

    Order sent(Long orderId);
}
