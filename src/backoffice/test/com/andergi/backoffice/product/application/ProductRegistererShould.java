package com.andergi.backoffice.product.application;

import com.andergi.backoffice.product.domain.Product;
import com.andergi.backoffice.product.domain.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

final class ProductRegistererShould {

    @Test
    void register_a_valid_product() {
        Product product = new Product("fake-id", "fake-name");
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductRegisterer registerer = new ProductRegisterer(productRepository);

        registerer.register(product.id(), product.name());

        verify(productRepository, atLeastOnce()).save(product);

    }
}