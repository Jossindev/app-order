package com.example.apporder.service.impl;

import com.example.apporder.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class OrderRequestService {
    private final RestTemplate template = new RestTemplate();
    private URI uri;
    @Value("${http.api2.order}")
    private String orderUrl;

    public Order saveOrder() {
        uri = checkCorrectURISyntax(orderUrl + "add");
        return template.postForObject(uri, new Order(), Order.class);
    }

    public void deleteOrder(Long orderId) {
        uri = checkCorrectURISyntax(orderUrl + orderId);
        template.delete(uri);
    }

    public void addProductToOrder(Long orderId, Long productId) {
        uri = checkCorrectURISyntax(orderUrl + orderId + "/addToOrder?productId=" + productId);
        template.put(uri, Order.class);
    }

    public void deleteProduct(Long orderId, Long productId) {
        uri = checkCorrectURISyntax(orderUrl + orderId + "/deleteFromOrder?productId=" + productId);
        template.delete(uri);
    }

    private URI checkCorrectURISyntax(String url) {
        try {
            return new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);//?????
        }
    }
}
