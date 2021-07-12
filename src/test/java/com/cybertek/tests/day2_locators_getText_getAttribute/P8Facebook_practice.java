package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P8Facebook_practice {
    public static void main(String[] args) {

//        TC #2: Facebook incorrect login title verification
//    1.Open Chrome browser
        WebDriverManager.chromedriver();
       WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//    2.Go to https://www.facebook.com/.
        driver.get("https://www.facebook.com");

//    3.Enter incorrect username
      //String actualUserName = "abcd";

//    4.Enter incorrect password
      //  String actualPassWord = "123";

//    5.Verify title changed to: Expected: “Log into Facebook | Facebook”
//        actualTitle = Facebook - Log In or Sign Up

//        String expectedTitle ="Facebook -Log In or Sign Up";
//        String actualTitle =driver.getTitle();
//
//        if(actualTitle.equals(expectedTitle)){
//            System.out.println("Successfully done");
//        }else{
//            System.out.println("Failed");
//        }


    }
}
