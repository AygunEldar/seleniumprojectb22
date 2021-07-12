package com.cybertek.officeHours_All.OfficeHours06_02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZeroBankAccountActivity4 {

    WebDriver driver;
    Select accountsDropDown;

    @BeforeClass
    public void setupClass4(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //1. The user navigates to the login page: http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //login
        //2. The user logs in with the user "username" and the password "password"
        //3. The user navigates to Account Activity page

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@id='primary-button']")).click();


    }
    @Test
    public void accountActivity4(){
        //4. Then The page should have the title "Zero - Account Activity"
        driver.findElement(By.cssSelector("[id*='acco']")).click();
        String expectedTitle ="Zero - Account Activity";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        //5. Then Account drop down should have the following options :
        //(Savings, Checking, Savings, Loan, Credit Card, Brokerage)
        List<String> expectedOptions =new ArrayList<>(Arrays.asList("Savings","Checking","Savings","Loan","Credit Card","Brokerage"));
        accountsDropDown = new Select(driver.findElement(By.cssSelector("[id*='aa']")));

        List<WebElement>actualOptions = accountsDropDown.getOptions();
        List<String> actualOptionsText = new ArrayList<>();
        for(WebElement each : actualOptions){
            actualOptionsText.add(each.getText());
        }
        System.out.println("expectedOption " +expectedOptions );
        System.out.println("actualOption "+actualOptions );
        System.out.println("actualOptionsText "+actualOptionsText );
        Assert.assertEquals(actualOptionsText,expectedOptions,"Verify DropDown Options");

        // make a mistake here, do without selecting brokerage
        // lets select

        accountsDropDown.selectByVisibleText("Brokerage");
        //6. Brokerage option should have "No results."
        String expectedText = "No results.";
        String actualText = driver.findElement(By.xpath("//div[@class='well']")).getText();

        Assert.assertEquals(actualText,expectedText,"verify result text");



    }
    @AfterClass
    public void tearDownClass(){

        driver.quit();
    }

}
