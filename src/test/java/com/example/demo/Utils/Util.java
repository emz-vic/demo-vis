package com.example.demo.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;

import static com.example.demo.Utils.BaseUiTest.getDriver;

public class Util {

    public static void switchToDemoIframe(int index){
        getDriver().switchTo().frame(index);
    }

    public static void waitForPageToLoad(){
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(pageLoadCondition);
    }

    public static void switchFocusToSecondTab() {
        Iterator<String> windowHandle = getDriver().getWindowHandles().iterator();
        String parent_window = windowHandle.next();
        String child_window = windowHandle.next();
        System.out.println(parent_window);
        System.out.println(child_window);

        getDriver().switchTo().window(child_window);
    }
}
