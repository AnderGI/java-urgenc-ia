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
        repository.save(new Product("fake-id", "fake-name"));
    }

    @Test
    void find_an_existing_product() {
        final Product product = new Product("fake-id-2", "fake-name");
        final InMemoryProductRepository repository = new InMemoryProductRepository();

        repository.save(product);
        Optional<Product> expected = repository.search(product.id());

        assertTrue(expected.isPresent());
        assertNotNull(expected.get());
        assertEquals(product, expected.get());
    }

    @Test
    void not_find_a_non_existing_product() {
        final Product product = new Product("fake-id-2", "fake-name");
        final InMemoryProductRepository repository = new InMemoryProductRepository();

        Optional<Product> expected = repository.search(product.id());

        assertFalse(expected.isPresent());
        assertThrows(NoSuchElementException.class, expected::get);
    }

}