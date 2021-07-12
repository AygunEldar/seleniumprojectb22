package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
//        TC #
//        2: Facebook incorrect login title verification
//                1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//    2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

//        // .Enter incorrect username
//        // 4.Enter incorrect password
    driver.findElement(By.name("email")).sendKeys("abcd");
    driver.findElement(By.name("pass")).sendKeys("1234"+ Keys.ENTER);
       Thread.sleep(4000);

//        // 5.Verify title changed to:
//        // Expected: “Log into Facebook”
        String expectedTitle ="Log into Facebook";
        String actualTitle =driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

    }
}
