package com.synclab.internship;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class FactorialRestControllerTest {

    @Test
    public void testFactorialEndpoint() {
        /*given()
          .when().get("/factorial/1")
          .then()
             .statusCode(200)
             .body(is("1"));*/
    }

}