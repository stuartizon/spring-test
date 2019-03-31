package com.stuartizon;

import org.junit.Test;

import static io.restassured.RestAssured.*;

import io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;


public class ExampleTest {
    @Test
    public void getReturnsHello() {
        System.out.println("It worked!");

        when()
                .get("/")
                .then()
                .body(equalTo("goodbye"));

    }
}
