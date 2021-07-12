package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_NEW {

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
        public void tc1_simple_dropdown_test(){

            // 3.Verify “Simple dropdown” default selected value is correct

            Select simpleDropDown = new Select (driver.findElement(By.xpath("//select[@id='dropdown']")));



            WebElement currentlySelectedOption = simpleDropDown.getFirstSelectedOption();

            String actualTextOfCurrentSelectedOption = currentlySelectedOption.getText();

            // Expected: “Please select an option”
            String expectedText = "Please select an option";

            //Assert.assertTrue(actualTextOfCurrentSelectedOption.equals(expectedText));
            Assert.assertEquals(actualTextOfCurrentSelectedOption,expectedText);

            //Doing everything in one line: get currently selected option, get the text and compare against expected
            //Assert.assertEquals(simpleDropdown.getFirstSelectedOption().getText(), "Please select an option");

            // 4.Verify“State selection” default selected value is correct
            // Expected: “Select a State”
            Select stateDropdown =new Select(driver.findElement(By.xpath("//select[@id='state']")));
            //Select stateDropdown =new Select(driver.findElement(By.id("state")));

            String actualStateDropdownText = stateDropdown.getFirstSelectedOption().getText();
            String expectedStateDropdownText = "Select a State";

            Assert.assertEquals(actualStateDropdownText,expectedStateDropdownText);
        }


  @AfterClass
    public void teardownClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
  }

}
