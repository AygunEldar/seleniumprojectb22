package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
    public static void main(String[] args) {
//      TC #4: Facebook header verification
//      1.Open Chrome browser
//      2.Go to https://www.facebook.com

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//    2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
   WebElement createPageLink = driver.findElement(By.className("_8esh"));
//      3.Verify “Create a page” link href value contains text:
//      Expected: “registration_form”
     //   driver.findElement(By.LinkText("registration_form"));

        String expectedLinkText ="registration_form";
        String actualLinkText = createPageLink.getAttribute("href");

        if(actualLinkText.contains(expectedLinkText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
