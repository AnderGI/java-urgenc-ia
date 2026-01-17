package com.andergi.apps.backoffice.controllers.product.register_product;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
final public class ProductPutController {

    @PutMapping(path = "/products/{id}")
    public ResponseEntity run(@PathVariable String id, @RequestBody ProductPutRequest productPutRequest) {
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

