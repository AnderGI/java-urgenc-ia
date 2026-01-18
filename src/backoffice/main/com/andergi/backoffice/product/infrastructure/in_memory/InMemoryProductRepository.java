package com.andergi.backoffice.product.infrastructure.in_memory;

import com.andergi.backoffice.product.domain.Product;
import com.andergi.backoffice.product.domain.ProductRepository;
import com.andergi.shared.domain.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public final class InMemoryProductRepository implements ProductRepository {
    private HashMap<String, Product> products = new HashMap<>();

    @Override
    public void save(final Product product) {
        products.put(product.id(), product);
    }

    @Override
    public Optional<Product> search(final String id) {
        return Optional.ofNullable(products.get(id));
    }
}
