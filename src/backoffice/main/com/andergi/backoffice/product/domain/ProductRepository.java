package com.andergi.backoffice.product.domain;

import java.util.Optional;

public interface ProductRepository {
    void save(final Product product);
    Optional<Product> search(final String id);
}
