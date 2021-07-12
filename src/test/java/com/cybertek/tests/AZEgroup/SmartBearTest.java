package com.cybertek.tests.AZEgroup;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBearTest {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
//TC #1: SmartBear software link verification
        // 1.Open browser
        // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx%22");
    }
    @Test
    public void logInTest() {
        SmartBearUtils.logIn(driver);
        SmartBearUtils.printAllLinks(driver);
        SmartBearUtils.order(driver);
    }
}
