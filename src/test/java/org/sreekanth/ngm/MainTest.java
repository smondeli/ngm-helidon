
package org.sreekanth.ngm;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.helidon.microprofile.tests.junit5.HelidonTest;

@HelidonTest
class MainTest {

    @Inject
    private WebTarget target;

    @Test
    void testHelloWorld() {
        try (Response r = target
                .path("/")
                .request()
                .get()) {
            Assertions.assertEquals(200, r.getStatus(), "GET / status");
        }

        try (Response r = target
                .path("/inventory")
                .request()
                .get()) {
            Assertions.assertEquals(200, r.getStatus(), "GET /inventory status");
        }

        try (Response r = target
                .path("/items")
                .request()
                .get()) {
            Assertions.assertEquals(200, r.getStatus(), "GET /items status");
        }

        try (Response r = target
                .path("metrics")
                .request()
                .get()) {
            Assertions.assertEquals(200, r.getStatus(), "GET metrics status code");
        }

        try (Response r = target
                .path("health")
                .request()
                .get()) {
            Assertions.assertEquals(200, r.getStatus(), "GET health status code");
        }
    }
}
