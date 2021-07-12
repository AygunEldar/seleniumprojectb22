package com.cybertek.tests.HomeTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBearTC3D_8 {
    //TC#3: Smartbear software order verification
    // 1.Open browser and login to Smartbear software


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }

    @Test
    public void click() throws InterruptedException {
        // 1.3.Enter username: “Tester”
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");

        // 1.4.Enter password: “test”
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");

        // 1.5.Click on Login button
        driver.findElement(By.xpath("//input[@class='button']")).click();
        Thread.sleep(2000);

        //3. 2.Click on View all orders
        WebElement viewBtn = driver.findElement(By.xpath("//a[@href='Default.aspx']"));

        // 3.Verify Susan McLaren has order on date “01/05/2010”
        WebElement date = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[6]//td[5]"));
        String expected = "01/05/2010";
        String actual = date.getText();
        Assert.assertEquals(actual, expected);

    }
    //PRACTICE #4: Method: verifyOrder•Create a method named verifyOrderin SmartBearUtils class.
    // •Methodtakes WebDriver object and String(name).
    // •Methodshould verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.

    //task 4 SmartBear
 //   @Test
//    public static void verifyOrder(WebDriver driver, String name) {
//
//        List<WebElement> allOrderNames = driver.findElements(By.xpath("table[@id='ctl00_MainContent_fmwOrder']//tr/td[2]"));
//
//
//        String expectedName = name;
//        for (WebElement eachOrderName : allOrderNames) {
//            if (eachOrderName.getText().equals(expectedName)) {
//                Assert.assertTrue(eachOrderName.getText().equals(name));
//                System.out.println("Passed");
//            } else {
//                Assert.fail("Failed");
//                System.out.println("Failed");
//
//            }
//            Assert.assertEquals(eachOrderName.getText(), expectedName);
//        }
//
//    }
    //Task 5
//    @Test
//    public static void printNamesAndEmails(WebDriver driver){


        //Practice #5: Method: printNamesAndEmails
        // •Create a method named printNamesAndEmailsin TableUtils class.
        // •Method takes WebDriver object.
        // •This method should simply print all the names and emails in the table
        // •Create a new TestNG test to test if the method is working as expected.
        // •Output should be like:
        // •Name1: name , Email1: email
        // •Name2: name , Email2: email
        // Use of the methods:
        // 1.Create a new class
        // 2.Create new Tests
        // 3.Read URL usingConfigurationReader.getProperty
        // 4.Test if the utility methods are working as expected.

        // List<WebElement>
   // }

}
