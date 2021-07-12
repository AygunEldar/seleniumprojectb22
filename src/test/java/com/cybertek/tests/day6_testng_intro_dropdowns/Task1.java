package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) {


        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 2.Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

        // 3.Verify “Simple dropdown” default selected value is correct
        //      Expected: “Please select an option”

        WebElement simple = driver.findElement(By.xpath("//select[@id='dropdown']"));
        String expected = "“Please select an option”";
        String actual = simple.getText();
        if(actual.equals(expected)){
            System.out.println("Verification PASSED.");
        }else{
            System.out.println("Verification FAILED.");
        }

        // 4.Verify“State selection” default selected value is correct
        //      Expected: “Select a State”

        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        String expected4 = "Select a State";
        String actual4 = simple.getText();

        if(actual4.equals(expected4)){
            System.out.println("Verification PASSED.");
        }else{
            System.out.println("Verification FAILED.");
        }
    }
}