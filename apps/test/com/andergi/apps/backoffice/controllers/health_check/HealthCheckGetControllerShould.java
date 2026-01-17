package com.andergi.apps.backoffice.controllers.health_check;

import com.andergi.apps.RequestTestCase;
import org.junit.jupiter.api.Test;

final class HealthCheckGetControllerShould extends RequestTestCase {
    @Test
    void check_the_app_is_working_ok() throws Exception{
        assertResponseWithNoBody("/health-check", 200);
    }
}