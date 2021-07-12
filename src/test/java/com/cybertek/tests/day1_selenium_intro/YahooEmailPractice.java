package com.cybertek.tests.day1_selenium_intro;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YahooEmailPractice {
    @Test

    public static void YahooTest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.yahoo.com/?.src=ym&pspid=159600001&activity=mail-direct&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");


        driver.manage().window().maximize();
        Thread.sleep(3000);

        if(driver.getTitle().equalsIgnoreCase("Yahoo")){
            System.out.println("Title of the page at mail.yahoo has been located / found");
        }else{
            System.out.println("FAILED:Title for mail.yahoo was not found");
        }


        List<String> YahooLogin = new ArrayList<>(Arrays.asList("UsernameSpaceCheck", "UsernameCredentials",
                "ClickNext", "PasswordSpaceCheck", "PasswordCredentials", "LoginButtonClick", "LoginSuccessful"));

        for(String loginInfo : YahooLogin) {
            switch (loginInfo) {

                case "UsernameSpaceCheck":
                    driver.findElement(By.id("login-username"));
                    System.out.println("Username login space successfully located");
                    Thread.sleep(2000);
                    break;

                case "UsernameCredentials":
                    driver.findElement(By.id("login-username")).sendKeys("batch22@yahoo.com");
                    System.out.println("Username space located and login credentials assigned");
                    Thread.sleep(2000);
                    break;

                case "ClickNext":
                    driver.findElement(By.id("login-signin")).click();
                    System.out.println("Next command executed. The following credential is password");
                    Thread.sleep(2000);
                    break;

                case "PasswordSpaceCheck":
                    driver.findElement(By.id("login-passwd"));
                    System.out.println("Password login space successfully located");
                    Thread.sleep(2000);
                    break;

                case "PasswordCredentials":
                    driver.findElement(By.id("login-passwd")).sendKeys("Feb21@2021");
                    System.out.println("Password entered");
                    Thread.sleep(2000);
                    break;

                case "LoginButtonClick":
                    driver.findElement(By.id("login-signin")).click();
                    Thread.sleep(2000);
                    break;

                case "LoginSuccessful":
                    System.out.println("Login Successful");
                    break;

                default:
                    System.out.println("Invalid Entry");
                    driver.quit();
                    break;


            }
        }

    }
}
