package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC3 {
    //TC #3: Selecting date on dropdown and verifying
    // 1.Open Chrome browser


    // Select year using: visible text
    // Select month using : value attribute
    // Select day using: index number

    @Test
    public void Test3(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2.Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        // 3.Select “December 1st, 1922” and verify it is selected.
        WebElement getMonthDropDown = driver.findElement(By.xpath("//select[@id='month']"));
        //getMonthDropDown.click();
        Select selectMonth = new Select(getMonthDropDown);
        selectMonth.selectByValue("11");


        WebElement getDateDropDown = driver.findElement(By.xpath("//select[@id='day']"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       // getDateDropDown.click();
        Select selectDate = new Select(getDateDropDown);
        selectDate.selectByIndex(0);


        WebElement getYearDropDown = driver.findElement(By.xpath("//select[@id='year']"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //getYearDropDown.click();
        Select selectYear = new Select(getYearDropDown);
        selectYear.selectByVisibleText("1922");

        String expectedMonth ="December";
                String actualMonth = selectMonth.getFirstSelectedOption().getText();

        Assert.assertEquals(actualMonth,expectedMonth);












    }

}
