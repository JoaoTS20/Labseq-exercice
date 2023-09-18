package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class LabSeqResourceTest {
    @Test
    public void testLabseqEndpoint() {
        given()
                .when().get("/api/labseq")
                .then()
                .statusCode(200)
                .body(is("HELLO THERE!s"));
    }
    @Test
    public void testLabseqIndexEndpoint() {
        given()
                .pathParam("n",3)
                .when().get("/api/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("1"));
    }
    @Test
    public void testLabseqIndexBadInputEndpoint() {
        given()
                .pathParam("n",-3)
                .when().get("/api/labseq/{n}")
                .then()
                .statusCode(400);
    }


}

