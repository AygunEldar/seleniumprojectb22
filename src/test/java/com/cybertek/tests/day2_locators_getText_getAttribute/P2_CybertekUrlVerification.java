package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekUrlVerification {
    public static void main (String [] args){
        //# Cybertek
        //Setup the browser driver
        WebDriverManager.chromedriver().setup();

        //1.Open Chrome browser
        WebDriver driver = new ChromeDriver();

        //maximize the page
        driver.manage().window().maximize();

        //2.Go to
        driver.get("http://practice.cybertekschool.com/");

        //3.Verify Url contains
        //expected: cybertekschool

        String expectedInUrl = "cybertekschool";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedInUrl)){
            System.out.println("URL verification Passed");
        }else{
            System.out.println("URL verification Failed");
        }

        //4Verify title
        //expected practice
        String expectedTitle ="Practice";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");

        }
    }




}
