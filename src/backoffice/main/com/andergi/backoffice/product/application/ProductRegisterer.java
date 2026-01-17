package com.andergi.backoffice.product.application;

import com.andergi.backoffice.product.domain.Product;
import com.andergi.backoffice.product.domain.ProductRepository;
import org.springframework.stereotype.Service;

// TODO change to a custom service annotation to contain vendor logic in one place only
@Service
final public class ProductRegisterer {

    private final ProductRepository repository;

    public ProductRegisterer(ProductRepository repository) {
        this.repository = repository;
    }

    public void register(String id, String name) {
        Product product = new Product(id, name);
        this.repository.save(product);
    }

}
