package com.example.apporder.service.impl;

import com.example.apporder.model.Product;
import com.example.apporder.persistenceapi.service.impl.ProductServiceImpl;
import com.example.apporder.persistenceapi.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    private static final Long PRODUCT_ID = 1L;
    @Spy
    @InjectMocks
    private ProductServiceImpl testInstance;

    @Mock
    private ProductRepository productRepository;

    @Mock
    Product product;

    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowEntityNotFoundException_whenProductNotFoundById() {
        when(productRepository.findById(PRODUCT_ID)).thenThrow(EntityNotFoundException.class);

        testInstance.getProduct(PRODUCT_ID);
    }

    @Test
    public void shouldGetProductById() {
        when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));

        Product actual = testInstance.getProduct(PRODUCT_ID);

        assertThat(actual).isSameAs(product);
    }

    @Test
    public void shouldReturnSavedProduct() {
        when(productRepository.save(product)).thenReturn(product);

        Product actual = testInstance.save(product);

        assertThat(actual).isSameAs(product);
    }
}
