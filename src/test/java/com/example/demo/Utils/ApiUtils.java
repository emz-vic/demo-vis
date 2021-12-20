package com.example.demo.Utils;

import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {
    public Response getPostWithTitle(String title){
        return given()
                .contentType(ContentType.JSON)
                .queryParam("title",title)
                .when()
                .get("/posts")
                .then()
                .extract().response();
    }

    public Response createNewUserWithDetails (JsonObject object){
        return given()
                .contentType(ContentType.JSON)
                .request().body(object)
                .when()
                .post("/users")
                .then()
                .extract().response();
    }
}
