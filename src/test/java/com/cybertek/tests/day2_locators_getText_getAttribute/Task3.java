package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    public static void main(String[] args) {
//        TC #3: Facebook header verification
//        1.Open Chrome browser
//        2.Go to https://www.facebook.com


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//    2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

//        3.Verify header text is as expected:
//        Expected: “Connect with friends and the world around you on Facebook.”
        WebElement actualHeader =driver.findElement(By.tagName("h2"));

        String expectedHeaderText ="Connect with friends and the world around you on Facebook.";
        String actualHeaderText= actualHeader.getText();

        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");}

    }
}
