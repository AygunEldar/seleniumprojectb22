package com.cybertek.tests.HomeTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBear_1 {
    //1.Open browser
    // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    // 3.Enter username: “Tester”
    // 4.Enter password: “test”
    // 5.Click to Login button
    // 6.Print out count of all the links on landing page
    // 7.Print out each link text on this page
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get( "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }
    @Test
    public void loginPage () throws InterruptedException {
       driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
       driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");
       driver.findElement(By.xpath("//input[@class='button']")).click();

        Thread.sleep(2000);
       
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("Total number of links in current page: " +allLinks);
        for (WebElement each : allLinks) {
            System.out.println(each.getText());

        }

    }

//
//        WebElement save = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
//        save.click();
        //table[@id='table1']//td[.='$50']/../td[2]


}
