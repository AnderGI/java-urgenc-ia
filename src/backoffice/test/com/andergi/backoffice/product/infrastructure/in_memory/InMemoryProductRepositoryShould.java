package com.andergi.backoffice.product.infrastructure.in_memory;

import com.andergi.backoffice.product.domain.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Optional;

final class InMemoryProductRepositoryShould {
    @Test
    void register_a_valid_product() {
        final InMemoryProductRepository repository = new InMemoryProductRepository();
        repository.save(new Product("c599b098-b4b3-4922-9696-d198bc5ecacc", "fake-name"));
    }

    @Test
    void find_an_existing_product() {
        final Product product = new Product("5b56fa6d-ff4a-42d8-af9a-e195dcedb573", "fake-name");
        final InMemoryProductRepository repository = new InMemoryProductRepository();

        repository.save(product);
        Optional<Product> expected = repository.search(product.id());

        assertTrue(expected.isPresent());
        assertNotNull(expected.get());
        assertEquals(product, expected.get());
    }

    @Test
    void not_find_a_non_existing_product() {
        final Product product = new Product("5b56fa6d-ff4a-42d8-af9a-e195dcedb573", "fake-name");
        final InMemoryProductRepository repository = new InMemoryProductRepository();

        Optional<Product> expected = repository.search(product.id());

        assertFalse(expected.isPresent());
        assertThrows(NoSuchElementException.class, expected::get);
    }

}