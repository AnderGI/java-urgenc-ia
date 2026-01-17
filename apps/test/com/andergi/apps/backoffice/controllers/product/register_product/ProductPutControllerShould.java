package com.andergi.apps.backoffice.controllers.product.register_product;

import com.andergi.apps.RequestTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public final class ProductPutControllerShould extends RequestTestCase {
    @Test
    public void register_a_product() throws Exception{
        assertRequestWithBody(
                "PUT",
                "/products/6793823e-20b1-4e28-927a-c221c285068b",
                """
                      {
                        "name": "Nike Dunk Low Retro"
                      }  
                      """,
                HttpStatus.ACCEPTED.value()
        );
    }
}
