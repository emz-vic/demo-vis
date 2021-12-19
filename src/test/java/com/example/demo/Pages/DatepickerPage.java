package com.example.demo.Pages;

import com.example.demo.Utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.example.demo.Utils.Util.switchToDemoIframe;
import static com.example.demo.Utils.Util.waitForPageToLoad;


public class DatepickerPage extends BaseTest {
    static WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    public static WebElement getDatepickerInput(){
        return getDriver().findElement(By.id("datepicker"));
    }

    public static WebElement getDatepickerElement(){
        return getDriver().findElement(By.id("ui-datepicker-div"));
    }

    public static WebElement getDatepickerCalendar (){
        return getDriver().findElement(By.cssSelector(".ui-datepicker-calendar"));
    }

    public static WebElement getFormatElement(){
        return getDriver().findElement(By.id("format"));
    }

    public static void clickFormatDate() {
        getDriver().findElement(By.cssSelector(".container .responsive-tabs-default li:nth-child(4)")).click();
        wait.until(ExpectedConditions.attributeContains(By.id("example-1-tab-4"),"style", "display: block;"));
    }

    public static void selectTodayDateFromCalendar(LocalDate currentDate){
        String day = String.valueOf(currentDate.getDayOfMonth());

        switchToDemoIframe(3);
        getDatepickerInput().click();
        wait.until(ExpectedConditions.elementToBeClickable(getDatepickerCalendar()));
        List<WebElement> dateColumns = getDriver().findElements(By.tagName("td"));
        clickGivenDay(dateColumns,day);
    }
    public static void selectFormatDate(String format){
        Select select = new Select(getFormatElement());
        select.selectByVisibleText(format);
    }

    public static void clickGivenDay(List<WebElement> elementList, String day) {
        elementList.stream()
                .filter(element -> element.getText().contains(day))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public static String getDatepickerInputText() throws IOException, UnsupportedFlavorException {
        getDatepickerInput().sendKeys(Keys.CONTROL + "a");
        getDatepickerInput().sendKeys(Keys.CONTROL + "c");
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = c.getContents(null);

        return (String) contents.getTransferData(DataFlavor.stringFlavor);
    }
}
