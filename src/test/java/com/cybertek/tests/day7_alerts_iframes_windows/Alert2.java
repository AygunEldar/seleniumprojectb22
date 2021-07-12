package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alert2 {


    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){

        //    TC #2: Confirmation alert practice
//1. Open browser
//2. Go to website: http://practice.cybertekschool.com/javascript_alerts
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }
    @Test
    public void click() throws InterruptedException {
        // 3. Click to “Click for JS Confirm” button
        WebElement infoClickBtn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));//.
        infoClickBtn.click();

        Alert alert = driver.switchTo().alert();

//4. Click to OK button from the alert
     alert.accept();
Thread.sleep(5000);//
//5. Verify “You clicked: Ok” text is displayed.
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String expected ="You clicked: Ok";
        String actual = result.getText();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(actual, expected);

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }




}
