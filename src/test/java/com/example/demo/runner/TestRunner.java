package com.example.demo.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(plugin = "pretty",
        features = {"src/test/resources/features/ApiTests.feature", "src/test/resources/features/UiTests.feature"},
        glue = {
        "com.example.demo.Definitions", "com.example.demo.Utils", "com.example.demo.ApiUtils"},
        tags = "not @ignore")
public class TestRunner {
}
