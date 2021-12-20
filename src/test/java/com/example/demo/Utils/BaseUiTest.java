package com.example.demo.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class BaseUiTest {
    private static ChromeDriver driver;
    private static Logger log = LoggerFactory.getLogger("BaseTest");

    public static WebDriver getDriver() {
        return driver;
    }

    @Before("@UiTest")
    public void setUp(){
        File file = new File("src/test/java/com/example/demo/Utils/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getPath());
        System.setProperty("java.awt.headless", "false");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("allow-unchecked-dangerous-downloads");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
    }

    @After("@UiTest")
    public void tearDown(){
        driver.quit();
    }
}
