package com.example.apporder.mainapi.service;

import com.example.apporder.model.Order;

import java.util.List;

public interface OrderRequestService {
    Order createOrder();

    List<Order> findOrders();

    void deleteOrder(Long orderId);

    void addProductToOrder(Long orderId, Long productId);

    void deleteProduct(Long orderId, Long productId);

    void sentOrder(Long orderId);
}
