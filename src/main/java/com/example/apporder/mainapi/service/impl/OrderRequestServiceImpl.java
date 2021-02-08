package com.example.apporder.mainapi.service.impl;

import com.example.apporder.mainapi.service.OrderRequestService;
import com.example.apporder.model.Order;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class OrderRequestServiceImpl  implements OrderRequestService {
    private final RestTemplate template = new RestTemplate();
    private URI uri;
    @Value("${http.api2.order}")
    private String orderUrl;

    public Order createOrder() {
        uri = returnCorrectUri(orderUrl + "add");
        return template.postForObject(uri, new Order(), Order.class);
    }

    public List<Order> findOrders() {
        uri = returnCorrectUri(orderUrl + "findAll");
        return template.getForObject(uri, List.class);
    }

    public void deleteOrder(Long orderId) {
        uri = returnCorrectUri(orderUrl + orderId);
        template.delete(uri);
    }

    public void addProductToOrder(Long orderId, Long productId) {
        uri = returnCorrectUri(orderUrl + orderId + "/addToOrder/" + productId);
        template.put(uri, Order.class);
    }

    public void deleteProduct(Long orderId, Long productId) {
        uri = returnCorrectUri(orderUrl + orderId + "/deleteFromOrder/" + productId);
        template.delete(uri);
    }

    public void sentOrder(Long orderId) {
        uri = returnCorrectUri(orderUrl + orderId + "/sent");
        template.put(uri, Order.class);
    }

    @SneakyThrows
    private URI returnCorrectUri(String url) {
            return new URI(url);
    }
}
