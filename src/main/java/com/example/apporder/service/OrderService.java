package com.example.apporder.service;

import com.example.apporder.model.Order;
import com.example.apporder.model.Product;
import com.example.apporder.repository.OrderRepository;
import com.example.apporder.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
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

        List<Product> orders = order.getProducts(); //stream???
        orders.add(product);
        order.setProducts(orders);

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

        List<Product> orders = order.getProducts(); //stream???
        orders.remove(product);
        order.setProducts(orders);
        orderRepository.save(order);
        return order;
    }
}
