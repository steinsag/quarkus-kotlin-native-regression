package com.example

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class ExampleResourceTest {

    @Test
    fun testHelloJsonEndpoint() {
        given()
            .`when`().get("/hello-json")
            .then()
            .statusCode(200)
            .body(`is`("{\"messages\":[]}"))
    }

    @Test
    fun testHelloStringEndpoint() {
        given()
            .`when`().get("/hello-string")
            .then()
            .statusCode(200)
            .body(`is`("{\"values\":{}}"))
    }
}
