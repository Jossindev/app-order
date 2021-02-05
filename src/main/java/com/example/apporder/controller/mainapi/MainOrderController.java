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
    public Order save() {
        return requestService.saveOrder();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        requestService.deleteOrder(id);
    }

    @PutMapping("/{id}/addToOrder")
    public void addProductToOrder(@PathVariable Long id, @RequestParam Long productId) {
        requestService.addProductToOrder(id, productId);
    }

    @DeleteMapping("/{id}/deleteFromOrder")
    public void deleteProductFromOrder(@PathVariable Long id, @RequestParam Long productId) {
        requestService.deleteProduct(id, productId);
    }

}
