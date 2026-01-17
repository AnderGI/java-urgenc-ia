package com.andergi.apps.backoffice.controllers.health_check;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckGetController {

    @GetMapping(path = "/health-check")
    public ResponseEntity<HttpStatusCode> run() {
        return new ResponseEntity<HttpStatusCode>(HttpStatusCode.valueOf(200));
    }

}
