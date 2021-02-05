package com.example.apporder.service.impl;

import com.example.apporder.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class ProductRequestService {
    private final RestTemplate template = new RestTemplate();
    private URI uri;
    @Value("${http.get.api2.product}")
    private String getProductUrl;

    public Product getProduct(Long productId) {
        try {
            uri = new URI(getProductUrl + productId);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return template.getForObject(uri, Product.class);
    }
}
