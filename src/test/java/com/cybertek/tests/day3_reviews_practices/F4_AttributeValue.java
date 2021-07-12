package com.cybertek.tests.day3_reviews_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class F4_AttributeValue {
    public static void main(String[] args) {
        //      TC #4: Facebook header verification
//      1.Open Chrome browser
//      2.Go to https://www.facebook.com
        //      3.Verify “Create a page” link href value contains text:
//      Expected: “registration_form”
//   driver.findElement(By.LinkText("registration_form"));

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        WebElement createPageLink = driver.findElement(By.linkText("Create a Page"));
        String expectedInHref = "registration_form";
        String actualHrefValue = createPageLink.getAttribute("href");
        if(actualHrefValue.contains(expectedInHref)){
            System.out.println("href value verification PASSED");
        }else{
            System.out.println("href value verification FAILED");
        }
    }
}
