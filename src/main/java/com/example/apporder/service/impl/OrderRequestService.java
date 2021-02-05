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
    @Value("${http.post.api2.order.save}")
    private String saveOrderUrl;
    @Value("${http.delete.api2.order}")
    private String deleteOrderUrl;

    public Order saveOrder() {
        try {
            uri = new URI(saveOrderUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return template.postForObject(uri, new Order(), Order.class);
    }

    public void deleteOrder(Long orderId) {
        try {
            uri = new URI(deleteOrderUrl + orderId);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        template.delete(uri);
    }
}
