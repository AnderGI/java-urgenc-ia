package com.andergi.backoffice.product.application.register;

import com.andergi.backoffice.product.domain.Product;
import com.andergi.backoffice.product.domain.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

final class ProductRegistererShould {

    @Test
    void register_a_valid_product() {
        Product product = new Product("a7a04462-ca83-40a1-be88-3646c8e931b9", "fake-name");
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductRegisterer registerer = new ProductRegisterer(productRepository);

        registerer.register(new RegisterProductCommand(product.id(), product.name()));

        verify(productRepository, atLeastOnce()).save(product);

    }
}