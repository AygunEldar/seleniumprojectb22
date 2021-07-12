package com.cybertek.tests.day3_reviews_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class F2_IncorrectLoginTitleVerification {
    public static void main(String[] args) throws InterruptedException {

//        //3 .Enter incorrect username
//        // 4.Enter incorrect password

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        WebElement inputUsername = driver.findElement(By.id("email"));
        inputUsername.sendKeys("something1213@gmail.com");

        WebElement inputPassword =driver.findElement(By.id("pass"));
        inputPassword.sendKeys("some wrong password " + Keys.ENTER);

        String expectedTitle ="Log into Facebook";
        Thread.sleep(5000);
        String actualTitle =driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
    }
}
