package com.cybertek.tests.day4_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task5_SmartbearSoft {
    public static void main(String[] args) {

        //TC#5: Basic login authentication
        // 1-Open a chrome browser
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver =new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // 2-Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // 3-Verify title equals:
        // Expected: Web Orders Login
        String expectedTitle ="Web Orders Login";
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("login page title verification PASSED");
        }else{
            System.out.println("Login page title verification FAILED");
        }

        // 4-Enter username: Tester
        WebElement inputUsername = driver.findElement(By.id("ctl00_MainContent_username"));

        // 5-Enter password: test
        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        inputPassword.sendKeys("test"+ Keys.ENTER);

        // 6-Click “Sign In” button
        WebElement inputSignInButton = driver.findElement(By.id("ctl00_MainContent_login_button"));

        // 7-Verify title equals:
        // Expected: Web Orders
        String expectedHomePageTitle ="Web Orders";
        String actualHomePageTitle = driver.getTitle();
        if(actualHomePageTitle.equals(expectedHomePageTitle)){
            System.out.println("Home page title verification PASSED");
        }else{
            System.out.println("Home page title verification FAILED");
        }
    }

}
