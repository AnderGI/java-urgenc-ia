package com.andergi.apps.backoffice.controllers.product.get_product_by_id;

import com.andergi.backoffice.product.application.find_by_id.ProductByIdFinder;
import com.andergi.backoffice.product.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ProductByIdGetController {

    private final ProductByIdFinder finder;

    public ProductByIdGetController(ProductByIdFinder finder) {
        this.finder = finder;
    }

    @GetMapping(path = "/products/{id}")
    public ResponseEntity<HashMap<String, String>> run(@PathVariable String id) {
        try {
            final Product product = finder.run(id);
            final HashMap<String, String> response = new HashMap<>();
            response.put("id", product.id());
            response.put("name", product.name());
            return ResponseEntity.ok().body(response);
        } catch (Exception exp) {
            return ResponseEntity.notFound().build();
        }

    }

}
