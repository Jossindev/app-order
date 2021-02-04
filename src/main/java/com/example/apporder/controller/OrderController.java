package com.example.apporder.controller;

import com.example.apporder.model.Order;
import com.example.apporder.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/service2/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    public Order save() {
        return orderService.save(new Order());
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    @PutMapping("/{id}/addToOrder")
    public Order addProductToOrder(@PathVariable Long id, @RequestParam Long productId) {
        return orderService.addProduct(id, productId);
    }

    @DeleteMapping("/{id}/deleteFromOrder")
    public Order deleteProduct(@PathVariable Long id, @RequestParam Long productId) {
        return orderService.deleteProduct(id, productId);
    }
}
