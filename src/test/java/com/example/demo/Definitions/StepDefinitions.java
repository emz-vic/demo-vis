package com.example.demo.Definitions;

import com.example.demo.Pages.AlertPage;
import com.example.demo.Pages.AutomationPracticePage;
import com.example.demo.Pages.DatepickerPage;
import com.example.demo.Utils.Context;
import com.example.demo.Utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@CucumberContextConfiguration
@SpringBootTest
public class StepDefinitions {

    private ScenarioContext context = new ScenarioContext();

    @Given("I navigate to automation practice site")
    public void iNavigateToAutomationPracticeSite() {
        AutomationPracticePage.navigateToAutomationPracticePage();
    }

    @When("I navigate to Alert category")
    public void iNavigateToAlertCategory() {
        AutomationPracticePage.clickAlertElementButton();
    }

    @And("I click to display input alert")
    public void iClickToDisplayInputAlert() {
        AlertPage.clickInputAlert();
        AlertPage.clickButtonToDisplayAlert();
    }

    @And("I enter my name in the input")
    public void iEnterMyNameInTheInput() {
        String name = "Emilian Vicovan";
        context.setContext(Context.NAME, name);
        AlertPage.sendKeysToInputAlert(name);
    }

    @Then("my name appears in the message")
    public void myNameAppearsInTheMessage() {
        Assert.assertTrue(AlertPage.getTextFromIframe().contains(context.getContext(Context.NAME).toString()));
    }

    @When("I navigate to Datepicker category")
    public void iNavigateToDatepickerCategory() {
        AutomationPracticePage.clickDatepickerElementButton();
    }

    @And("I go to format date option")
    public void iGoToFormatDateOption() {
        DatepickerPage.clickFormatDate();
    }

    @And("I select today's date and ISO 8601 format")
    public void iSelectTodaySDateAndISOFormat() {
        LocalDate currentDate = LocalDate.now();
        context.setContext(Context.DATE, currentDate);
        DatepickerPage.selectTodayDateFromCalendar(currentDate);
        DatepickerPage.selectFormatDate("ISO 8601 - yy-mm-dd");
    }

    @Then("the date is formatted accordingly")
    public void theDateIsFormattedAccordingly() throws IOException, UnsupportedFlavorException {
        LocalDate currentDate = (LocalDate) context.getContext(Context.DATE);
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();

        String expectedDate = currentYear + "-" + currentMonth + "-" + currentDay;

        Assert.assertEquals(DatepickerPage.getDatepickerInputText(), expectedDate);
    }
}
