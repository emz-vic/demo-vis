package com.example.demo.Pages;

import com.example.demo.Utils.BaseTest;
import com.example.demo.Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.example.demo.Utils.Util.switchToDemoIframe;
import static com.example.demo.Utils.Util.waitForPageToLoad;


public class AlertPage extends BaseTest {
    static WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    public static void clickInputAlert() {
        getDriver().findElement(By.cssSelector(".container .responsive-tabs-default li:nth-child(2)")).click();
        wait.until(ExpectedConditions.attributeContains(By.id("example-1-tab-2"),"style", "display: block;"));
    }

    public static void clickButtonToDisplayAlert(){
        switchToDemoIframe(1);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
        element.click();

        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void sendKeysToInputAlert(String keys){
        getDriver().switchTo().alert().sendKeys(keys);
        getDriver().switchTo().alert().accept();
        waitForPageToLoad();
    }

    public static String getTextFromIframe(){
        return getDriver().findElement(By.id("demo")).getText();
    }
}
