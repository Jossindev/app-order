package com.example.apporder.service.impl;

import com.example.apporder.model.Order;
import com.example.apporder.model.Product;
import com.example.apporder.repository.OrderRepository;
import com.example.apporder.repository.ProductRepository;
import com.example.apporder.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Transactional
    public Order addProduct(Long orderId, Long productId) {
        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found by id: " + orderId));
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found by id: " + productId));

        order.getProducts().add(product);
        return orderRepository.save(order);
    }

    @Transactional
    public Order deleteProduct(Long orderId, Long productId) {
        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found by id: " + orderId));
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found by id: " + productId));

        order.getProducts().remove(product);
        return orderRepository.save(order);
    }
}
