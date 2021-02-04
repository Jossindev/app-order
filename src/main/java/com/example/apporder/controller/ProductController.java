package com.example.apporder.controller;

import com.example.apporder.model.Product;
import com.example.apporder.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/service2/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return productService.getProduct(id);
    }
}
