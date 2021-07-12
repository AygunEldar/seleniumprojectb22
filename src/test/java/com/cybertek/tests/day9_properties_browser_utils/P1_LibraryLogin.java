package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.LibraryUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P1_LibraryLogin {

    //Task #2:
    //• Create a method called loginToLibrary in the same java class with the @Test
    //• This method simply logs in to Library app when you call it.
    //Task #3:
    //• Create a new class under ‘utilities’ package named “LibraryUtilities”
    //• Move loginToLibrary method from the same java class to “LibraryUtilities”
    //• Overcome the challenge so it works when you call from the other class.
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        //2. Go to website: c
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://library2.cybertekschool.com/login.html");

    }


    @Test
    public void login_link_count_test(){
        //ask #1: Library software link verification
        //LoginMethod  calling to login library app
        LibraryUtils.loginToLibrary(driver);




        //6. Print out count of all the links on landing page
        BrowserUtils.sleep(2);
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("allLinks.size() = " + allLinks.size());

        //7. Print out each link text on this page
        for(WebElement each : allLinks){
            System.out.println(each.getText());
        }
        // username password
        //student11@library                   tScBPCUr
        //student12@library                  UC0LC9Hj
        //student13@library                   zcVbvUWH
        //librarian13@library                  9rf6axdD



    }
}
