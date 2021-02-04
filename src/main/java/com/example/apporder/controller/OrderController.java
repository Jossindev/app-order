package com.example.apporder.controller;

import com.example.apporder.model.Order;
import com.example.apporder.repository.OrderRepository;
import com.example.apporder.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private final OrderRepository orderRepository;
    private final OrderService orderService;

//    @PostMapping("/add")
//    public Order save(@RequestBody Order order) {
//        return orderRepository.save(order);
//    }

    @PostMapping("/add")
    public Order save() {
        return orderRepository.save(new Order());
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        orderRepository.deleteById(id);
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
