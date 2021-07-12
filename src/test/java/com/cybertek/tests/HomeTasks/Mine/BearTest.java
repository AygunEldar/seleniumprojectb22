package com.cybertek.tests.HomeTasks.Mine;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BearTest {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void signInTest() {
        BearUtils.signIn(driver);
        //  BearUtils.printTotal(driver);
        //   BearUtils.select(driver);
        // BearUtils.click(driver);
        //  BearUtils.verifyOrder(driver, "Samuel Clemens");
    }
        @Test
                public void print(){
            BearUtils.signIn(driver);
           BearUtils.printNamesAndCities(driver);
    }




    @AfterMethod
    public void teardownClass() throws InterruptedException {
        BrowserUtils.sleep(3);
      //  driver.close();

    }
}
