package com.example.demo.Definitions;

import com.example.demo.Utils.ApiUtils;
import com.example.demo.Utils.Context;
import com.example.demo.Utils.ScenarioContext;
import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.response.Response;
import org.testng.Assert;


public class ApiStepDefinitions {

    private ScenarioContext context = new ScenarioContext();
    public ApiUtils apiUtils = new ApiUtils();

    @Given("I make a get with title qui est esse")
    public void iMakeAGetWithTitleQuiEstEsse() {
        String title = "qui est esse";
        Response response = apiUtils.getPostWithTitle(title);
        context.setContext(Context.RESPONSE, response);
    }

    @Given("I send a post with new user details")
    public void iSendAPostWithNewUserDetails() {
        JsonObject requestParams = new JsonObject();
        requestParams.add("name", "John Doe");
        requestParams.add("username", "userJoe");
        requestParams.add("email", "john@doe.com");

        Response response = apiUtils
                .createNewUserWithDetails(requestParams);
        context.setContext(Context.RESPONSE, response);
    }

    @Then("I get all post details")
    public void iGetAllPostDetails() {
        Response response = (Response) context.getContext(Context.RESPONSE);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("qui est esse"));
    }

    @Then("the user is created")
    public void theUserIsCreated() {
        Response response = (Response) context.getContext(Context.RESPONSE);

        Assert.assertEquals(response.statusCode(), 201);
    }


    @Then("the response is under {int} milisecons")
    public void theResponseIsUnderMilisecons(int milliseconds) {
        Response response = (Response) context.getContext(Context.RESPONSE);
        Assert.assertTrue(response.getTime() < milliseconds, "Current response time is " + response.getTime());
    }
}
