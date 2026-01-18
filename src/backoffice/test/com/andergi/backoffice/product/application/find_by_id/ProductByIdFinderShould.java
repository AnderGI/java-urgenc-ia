package com.andergi.backoffice.product.application.find_by_id;

import com.andergi.backoffice.product.domain.Product;
import com.andergi.backoffice.product.domain.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

final class ProductByIdFinderShould {

    @Test
    void find_an_existing_product() throws Exception {
        Product product = new Product("fake-id", "fake-name");
        ProductRepository repository = Mockito.mock(ProductRepository.class);
        ProductByIdFinder finder = new ProductByIdFinder(repository);

        when(repository.search(product.id())).thenReturn(Optional.of(product));
        Product expected = finder.run(product.id());

        verify(repository, atLeastOnce()).search(product.id());
        assertNotNull(expected);
        assertEquals(expected, product);


    }

    @Test
    void throw_an_exception_when_finding_non_existing_product() {
        Product product = new Product("fake-id", "fake-name");
        ProductRepository repository = Mockito.mock(ProductRepository.class);
        ProductByIdFinder finder = new ProductByIdFinder(repository);

        when(repository.search(product.id())).thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> { finder.run(product.id());});

    }

}