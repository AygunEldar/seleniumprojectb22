package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task2 {
    WebDriver driver;
    @BeforeClass
    public void setupClass() {
        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        // 1.Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 2.Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    @Test
    public  void tc2_state_dropdown_test() throws InterruptedException {

        //locating state dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        // 3.Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        // 4.Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");

        // 5.Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);


        // 6.Verify final selected option is California.
        // Use all Select options.(visible text, value, index)

  String expectedOptionText ="California";
  String actualOptionText = stateDropdown.getFirstSelectedOption().getText();


        Assert.assertEquals(actualOptionText,expectedOptionText,"this message will be printed if only the assertion FAILS");
        //Assert.assertTrue(stateDropdown.getFirstSelectedOption().getText().equals("California"));
    }
    @AfterClass
    public void teardownClass(){
        driver.close();
    }

}
