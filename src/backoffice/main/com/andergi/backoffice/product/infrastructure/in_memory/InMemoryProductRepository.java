package com.andergi.backoffice.product.infrastructure.in_memory;

import com.andergi.backoffice.product.domain.Product;
import com.andergi.backoffice.product.domain.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

// TODO change to a custom service annotation to contain vendor logic in one place only
@Service
public final class InMemoryProductRepository implements ProductRepository {
    private HashMap<String, Product> products = new HashMap<>();

    @Override
    public void save(Product product) {
        products.put(product.id(), product);
    }
}
