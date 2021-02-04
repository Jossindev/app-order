package com.example.apporder.service;

import com.example.apporder.model.Order;
import com.example.apporder.model.Product;
import com.example.apporder.repository.OrderRepository;
import com.example.apporder.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public Order addProduct(Long orderId, Long productId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found by id: " + orderId));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found by id: " + productId));

        order.getProducts().add(product);
        return order;
    }

    public Order deleteProduct(Long orderId, Long productId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found by id: " + orderId));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found by id: " + productId));

        order.getProducts().remove(product);
        return order;
    }

}
