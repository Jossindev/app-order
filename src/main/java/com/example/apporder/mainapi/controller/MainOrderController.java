package com.example.apporder.mainapi.controller;

import com.example.apporder.mainapi.service.OrderRequestService;
import com.example.apporder.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api1/orders")
public class MainOrderController {
    private final OrderRequestService requestService;

    @PostMapping("/add")
    public ResponseEntity<Order> createOrder() {
        Order order = requestService.createOrder();
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        requestService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/sent")
    public ResponseEntity<?> sentOrder(@PathVariable Long id) {
        requestService.sentOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/addToOrder/{productId}")
    public ResponseEntity<?> addProductToOrder(@PathVariable Long id, @PathVariable Long productId) {
        requestService.addProductToOrder(id, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/deleteFromOrder/{productId}")
    public ResponseEntity<?> deleteProductFromOrder(@PathVariable Long id, @PathVariable Long productId) {
        requestService.deleteProduct(id, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Order>> findAllOrders() {
        List<Order> orders = requestService.findOrders();
        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }
}
