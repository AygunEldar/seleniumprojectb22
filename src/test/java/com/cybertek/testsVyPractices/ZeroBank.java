package com.cybertek.testsVyPractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ZeroBank {
    public static void main(String[] args) throws InterruptedException {

        //Zero Bank Project:
        //
        WebDriverManager.chromedriver().setup();
        //1. Open Google Browser
        //
        WebDriver driver  =new ChromeDriver();
        //2. Go to http://zero.webappsecurity.com/   and make the screen full screen
        //
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/ ");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //3. Click on the Sign In Button
        //
        driver.findElement(By.id("signin_button")).click();
        //4. Locate USERNAME and PASSWORD spaces
        //
       driver.findElement(By.id("user_login")).sendKeys("username");
       driver.findElement(By.id("user_password")).sendKeys("password" + Keys.ENTER);

      // driver.findElement(By.className("secondary-button small-link").click());

        Thread.sleep(3000);
        //5. Send keys for both login credential spaces - meaning for Username and Password
        //
        //6. Access to the login page / dashboard right after entering keys.
        //
        //7. Check the Page Title and make sure that is the expected Title with condition
        //

        String  actualTitle = driver.getTitle();
        String expectedTitle = "Zero - Account Summary";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification Failed");
        }
        //8. Switch among the TABS and come to the TRANSFER FUNDS tab
        //
        //9. Locate From Account and Choose the Savings account with "$ 1548"
        //
        //10. Locate  To Account andChoose the account with  "-$500.2"
        //
        //11. Locate Amount space and Insert "$750"
        //
        //12. Locate description space and insert "Save someone from Bankruptcy :)" and CLICK Submit Button
        //
        //RESULT PAGE: "You successfully submitted your transaction."
    }
}
