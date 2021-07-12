package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P7_2_ZerobankAttributeVerification {
    public static void main(String[] args) {

//        TC #2: Zero Bank link text verification
//        1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");


        //LOCATE THE LINK AND STORE INSIDE OF WebElement

        WebElement zeroBankLink  = driver.findElement(By.className("brand"));

        //3.verify link text from top left
        //expected " Zero Bank"

        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBankLink.getText();
        //driver.findElement(By.className("brand)).getText();

        if(actualLinkText.equals(expectedLinkText)){
            System.out.println("link text verification PASSED!");
        }else{
            System.out.println("link text verification FAILED!");
        }

//        4. Verify link href attribute value contains:
//        Expected: “index.html”

        String expectedInHrefValue ="index.html";

        String actualHrefValue = zeroBankLink.getAttribute("href");
        if(actualHrefValue.contains(expectedInHrefValue)){
            System.out.println("HREF attribute value verification PASSED");
        }else{
            System.out.println("HREF attribute value verification FAILED");
        }


//        TC #2: Zero Bank link text verification
//        1. Open Chrome browser
//        2. Go to http://zero.webappsecurity.com/login.html 3. Verify link text from top left:
//        Expected: “Zero Bank”
//        4. Verify link href attribute value contains:
//        Expected: “index.html”
//
    }
}
