package com.example.apporder.controller;

import com.example.apporder.mainapi.controller.MainProductController;
import com.example.apporder.mainapi.service.impl.ProductRequestServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainProductControllerTest {
    private static final Long PRODUCT_ID = 1L;

    @Spy
    @InjectMocks
    private MainProductController testInstance;

    @Mock
    private ProductRequestServiceImpl productService;

    @Test
    public void shouldInvokeCreateOrderMethod_whenAddNewOrder() {
        testInstance.getProduct(PRODUCT_ID);

        verify(productService).getProduct(PRODUCT_ID);
    }
}
