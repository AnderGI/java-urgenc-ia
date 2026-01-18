package com.andergi.apps.backoffice.controllers.product.get_product_by_id;

import com.andergi.apps.RequestTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ProductByIdGetControllerShould extends RequestTestCase {

    @Test
    public void find_an_existing_product() throws Exception {
        assertRequestWithBody(
                "PUT",
                "/products/020d0409-8def-4fdb-995a-0cecae599389",
                """
                     {
                        "name": "some-product-name"
                     }
                     """,
                HttpStatus.ACCEPTED.value()
        );

        assertResponseWithBody(
                "/products/020d0409-8def-4fdb-995a-0cecae599389",
                HttpStatus.OK.value(),
                """
                    {
                        "name": "some-product-name"
                    }
                    """
        );
    }


    @Test
    public void not_find_and_existing_product() throws Exception {
        assertResponseWithNoBody(
                "/products/69feb5e1-4c72-46ae-b6ef-4008fe2d626a",
                HttpStatus.NOT_FOUND.value()
        );
    }

}