package com.example.apporder.controller.mainapi;

import com.example.apporder.model.Product;
import com.example.apporder.service.impl.ProductRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api1/products")
public class MainProductController {
    private final ProductRequestService productRequestService;

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRequestService.getProduct(id);
    }
}
