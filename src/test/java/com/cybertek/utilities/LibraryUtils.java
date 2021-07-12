package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LibraryUtils {


    public static void loginToLibrary(WebDriver driver) {
        //3Enter username
        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        inputUserName.sendKeys("student11@library");

        //4. Enter password: “”
        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        password.sendKeys(" tScBPCUr");

        //5. Click to Login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        loginBtn.click();
    }
}