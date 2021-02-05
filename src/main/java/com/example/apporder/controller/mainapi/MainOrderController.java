package com.example.apporder.controller.mainapi;

import com.example.apporder.model.Order;
import com.example.apporder.service.impl.OrderRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}/addToOrder/{productId}")
    public void addProductToOrder(@PathVariable Long id, @PathVariable Long productId) {
        requestService.addProductToOrder(id, productId);
    }

    @DeleteMapping("/{id}/deleteFromOrder/{productId}")
    public void deleteProductFromOrder(@PathVariable Long id, @PathVariable Long productId) {
        requestService.deleteProduct(id, productId);
    }

    @PutMapping("/{id}/sent")
    public void deleteProductFromOrder(@PathVariable Long id) {
        requestService.sentProduct(id);
    }

}
