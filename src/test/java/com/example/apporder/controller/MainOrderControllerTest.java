package com.example.apporder.controller;

import com.example.apporder.controller.mainapi.MainOrderController;
import com.example.apporder.service.impl.OrderRequestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainOrderControllerTest {
    private static final Long ORDER_ID = 1L;
    private static final Long PRODUCT_ID = 1L;

    @Spy
    @InjectMocks
    private MainOrderController testInstance;

    @Mock
    private OrderRequestService orderRequestService;

    @Test
    public void shouldInvokeCreateOrderMethod_whenAddNewOrder() {
        testInstance.createOrder();

        verify(orderRequestService).createOrder();
    }

    @Test
    public void shouldInvokeDeleteOrderMethod_whenDeleteOrder() {
        testInstance.deleteOrder(ORDER_ID);

        verify(orderRequestService).deleteOrder(ORDER_ID);
    }

    @Test
    public void shouldInvokeSentOrderMethod_whenSentOrder() {
        testInstance.sentOrder(ORDER_ID);

        verify(orderRequestService).sentOrder(ORDER_ID);
    }

    @Test
    public void shouldInvokeAddProductToOrderMethod_whenAddProductToOrder() {
        testInstance.addProductToOrder(ORDER_ID, PRODUCT_ID);

        verify(orderRequestService).addProductToOrder(ORDER_ID, PRODUCT_ID);
    }

    @Test
    public void shouldInvokeDeleteProductFromOrderMethod_whenDeleteProductFromOrder() {
        testInstance.deleteProductFromOrder(ORDER_ID, PRODUCT_ID);

        verify(orderRequestService).deleteProduct(ORDER_ID, PRODUCT_ID);
    }

    @Test
    public void shouldInvokeFindAllOrderMethod_whenFindAllOrder() {
        testInstance.findAllOrders();

        verify(orderRequestService).findOrders();
    }
}
