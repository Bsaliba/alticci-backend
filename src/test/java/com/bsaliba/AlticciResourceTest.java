package com.bsaliba;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class AlticciResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
          .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
          .when()
          .get("/alticci/14")
          .then()
             .statusCode(200)
             .body("number", is(28));
    }

}