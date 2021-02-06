package com.example.apporder.persistenceapi.service;

import com.example.apporder.model.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    void deleteById(Long orderId);

    Order addProduct(Long orderId, Long productId);

    Order deleteProduct(Long orderId, Long productId);

    Order sent(Long orderId);

    List<Order> findAll();
}
