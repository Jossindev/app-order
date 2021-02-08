package com.example.apporder.mainapi.controller;

import com.example.apporder.mainapi.service.ProductRequestService;
import com.example.apporder.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productRequestService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
