package com.andergi.backoffice.product.infrastructure.in_memory;

import com.andergi.backoffice.product.domain.Product;
import org.junit.jupiter.api.Test;

final class InMemoryProductRepositoryShould {
    @Test
    void register_a_valid_product() {
        final InMemoryProductRepository repository = new InMemoryProductRepository();
        repository.save(new Product("fake-id", "fake-name"));
    }
}