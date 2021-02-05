package com.example.apporder.controller.persistanceapi;

import com.example.apporder.model.Order;
import com.example.apporder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api2/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    @PutMapping("/{id}/addToOrder/{productId}")
    public Order addProductToOrder(@PathVariable Long id, @PathVariable Long productId) {
        return orderService.addProduct(id, productId);
    }

    @DeleteMapping("/{id}/deleteFromOrder/{productId}")
    public Order deleteProduct(@PathVariable Long id, @PathVariable Long productId) {
        return orderService.deleteProduct(id, productId);
    }

    @PutMapping("/{id}/sent")
    public Order sentOrder(@PathVariable Long id) {
        return orderService.sent(id);
    }
}

