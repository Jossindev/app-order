package com.example.apporder.mainapi.controller;

import com.example.apporder.mainapi.service.OrderRequestService;
import com.example.apporder.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api1/orders")
public class MainOrderController {
    private final OrderRequestService requestService;

    @PostMapping("/add")
    public Order createOrder() {
        return requestService.createOrder();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        requestService.deleteOrder(id);
    }

    @PutMapping("/{id}/sent")
    public void sentOrder(@PathVariable Long id) {
        requestService.sentOrder(id);
    }

    @PutMapping("/{id}/addToOrder/{productId}")
    public void addProductToOrder(@PathVariable Long id, @PathVariable Long productId) {
        requestService.addProductToOrder(id, productId);
    }

    @DeleteMapping("/{id}/deleteFromOrder/{productId}")
    public void deleteProductFromOrder(@PathVariable Long id, @PathVariable Long productId) {
        requestService.deleteProduct(id, productId);
    }

    @GetMapping("/findAll")
    public List<Order> findAllOrders() {
        return requestService.findOrders();
    }
}
