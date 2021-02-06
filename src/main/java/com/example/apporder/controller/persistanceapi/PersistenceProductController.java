package com.example.apporder.controller.persistanceapi;

import com.example.apporder.model.Product;
import com.example.apporder.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api2/products")
public class PersistenceProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return productService.getProduct(id);
    }
}
