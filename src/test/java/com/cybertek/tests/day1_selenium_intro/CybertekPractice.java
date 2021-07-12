package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekPractice {
    public static void main(String[] args) throws InterruptedException {

//        TC #1: Yahoo Title Verification

        WebDriverManager.chromedriver().setup();

//        1. Open Chrome browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

//        2. Go to https://practice.cybertekschool.com
            driver.get("https://www.cybertekschool.com");


//        3. Verify title:
        //  Expected: Practice
        String currentUrl ="Cybertek";
        System.out.println("currentUrl = " + currentUrl);
        Thread.sleep(5000);

        driver.navigate().back();

       Thread.sleep(5000);
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com");

        System.out.println("Current title " +driver.getTitle());

        currentUrl =driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        driver.close();
        driver.quit();
    }
}
