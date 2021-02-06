package com.example.apporder.service.impl;

import com.example.apporder.model.Order;
import com.example.apporder.model.Product;
import com.example.apporder.model.Status;
import com.example.apporder.repository.OrderRepository;
import com.example.apporder.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    private static final Long ORDER_ID = 1L;
    private static final Long PRODUCT_ID = 1L;

    @Spy
    @InjectMocks
    private OrderServiceImpl testInstance;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private Order order;

    @Mock
    private Product product;

    private List<Product> productsToPerform;

    @Before
    public void setUp() {
        productsToPerform = Arrays.asList(product, product, product);
    }

    @Test
    public void shouldReturnSavedOrder() {
        when(orderRepository.save(order)).thenReturn(order);

        Order actual = testInstance.save(order);

        assertThat(actual).isSameAs(order);
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowEntityNotFoundException_whenOrderNotFoundById() {
        when(orderRepository.findById(ORDER_ID)).thenThrow(EntityNotFoundException.class);

        testInstance.addProduct(ORDER_ID, PRODUCT_ID);
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowEntityNotFoundException_whenProductNotFoundById() {
        when(productRepository.findById(PRODUCT_ID)).thenThrow(EntityNotFoundException.class);

        testInstance.addProduct(ORDER_ID, PRODUCT_ID);
    }

    @Test
    public void shouldAddProductToOrder() {
        when(orderRepository.findById(ORDER_ID)).thenReturn(Optional.of(order));
        when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));
        testInstance.addProduct(ORDER_ID, PRODUCT_ID);

        assertThat(productsToPerform.size()).isEqualTo(3);

        verify(orderRepository).save(order);
    }

    @Test
    public void shouldRemoveProductFromOrder() {
        when(orderRepository.findById(ORDER_ID)).thenReturn(Optional.of(order));
        when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));
        testInstance.deleteProduct(ORDER_ID, PRODUCT_ID);

        assertThat(productsToPerform.size()).isEqualTo(3);

        verify(orderRepository).save(order);
    }

    @Test
    public void shouldUpdateStatusToSent() {
        when(orderRepository.findById(ORDER_ID)).thenReturn(Optional.of(order));

        testInstance.sent(ORDER_ID);

        verify(order).setStatus(Status.SENT);
        verify(orderRepository).save(order);
    }
}
