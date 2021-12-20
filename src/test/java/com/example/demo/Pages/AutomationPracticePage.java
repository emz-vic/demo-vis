package com.example.demo.Pages;

import com.example.demo.Utils.BaseUiTest;
import com.example.demo.Utils.Util;
import org.openqa.selenium.By;

public class AutomationPracticePage extends BaseUiTest {
    public static void clickAlertElementButton() {
        getDriver().findElement(By.linkText("Alert")).click();
        Util.waitForPageToLoad();
        Util.switchFocusToSecondTab();
    }
    public static void clickDatepickerElementButton() {
        getDriver().findElement(By.linkText("Datepicker")).click();
        Util.waitForPageToLoad();
        Util.switchFocusToSecondTab();
    }

    public static void navigateToAutomationPracticePage(){
        getDriver().navigate().to("https://www.way2automation.com/way2auto_jquery/automation-practice-site.html");
        Util.waitForPageToLoad();
    }
}
