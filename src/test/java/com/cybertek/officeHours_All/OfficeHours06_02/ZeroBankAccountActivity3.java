package com.cybertek.officeHours_All.OfficeHours06_02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZeroBankAccountActivity3 {
    WebDriver driver;
    Select accountsDropDown;

    @BeforeMethod
    public void setupClass3(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //1. The user navigates to the login page: http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //login
        //2. The user logs in with the user "username" and the password "password"
        //3. The user navigates to Account Activity page

        driver.findElement(By.cssSelector("[id*='user_log']")).sendKeys("username");
        driver.findElement(By.cssSelector("[id*='user_pass']")).sendKeys("password");
        driver.findElement(By.cssSelector("[type*='sub']")).click();
        driver.findElement(By.cssSelector("[id*='primary-']")).click();
        driver.findElement(By.cssSelector("[id*='acco']")).click();

    }
    @Test
    public void accountActivity31() {
        //4. Then The page should have the title "Zero - Account Activity"

        String expectedTitle = "Zero - Account Activity";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
            public void accountActivity32() {

        //5. Then Account drop down should have the following options :
        //(Savings, Checking, Savings, Loan, Credit Card, Brokerage)
        List<String> expectedOptions = new ArrayList<>(Arrays.asList("Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage"));
        accountsDropDown = new Select(driver.findElement(By.cssSelector("[id*='aa']")));

        List<WebElement> actualOptions = accountsDropDown.getOptions();
        List<String> actualOptionsText = new ArrayList<>();
        for (WebElement each : actualOptions) {
            actualOptionsText.add(each.getText());
        }
        System.out.println("expectedOption " + expectedOptions);
        System.out.println("actualOption " + actualOptions);
        System.out.println("actualOptionsText " + actualOptionsText);
        Assert.assertEquals(actualOptionsText, expectedOptions, "Verify DropDown Options");
    }
        @Test
        public void accountActivity33() {
        //6. Brokerage option should have "No results."
        String expectedText = "No results.";
        String actualText = driver.findElement(By.cssSelector("[class*='well']")).getText();

        Assert.assertEquals(actualText,expectedText);



    }
    @AfterMethod
    public void tearDownClass(){

        driver.close();
    }
}
