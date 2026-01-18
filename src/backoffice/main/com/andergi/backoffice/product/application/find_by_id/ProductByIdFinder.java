package com.andergi.backoffice.product.application.find_by_id;

import com.andergi.backoffice.product.domain.Product;
import com.andergi.backoffice.product.domain.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductByIdFinder {

    private final ProductRepository repository;

    public ProductByIdFinder(ProductRepository repository) {
        this.repository = repository;
    }

    public Product run(final String id) throws Exception {
        Optional<Product> searched = this.repository.search(id);

        if(searched.isEmpty()) {
            throw new Exception("No product found");
        }

        return searched.get();
    }

}
