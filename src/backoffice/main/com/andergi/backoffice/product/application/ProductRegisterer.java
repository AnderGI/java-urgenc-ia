package com.andergi.backoffice.product.application;

import com.andergi.backoffice.product.domain.Product;
import com.andergi.backoffice.product.domain.ProductRepository;

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
