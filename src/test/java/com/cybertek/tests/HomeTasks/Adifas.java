package com.cybertek.tests.HomeTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Adifas {
    //You have to implement the following Web automated checks over our (Adifas) DEMO ONLINE SHOP: https://www.demoblaze.com/index.html

    //• Navigate to "Cart" → Delete "Apple monitor 24" from cart.
    //• Click on "Place order".
    //• Fill in all web form fields.
    //• Click on "Purchase"
    //• Capture and log purchase Id and Amount.
    //• Assert purchase amount equals expected.
    //• Click on "Ok"

    WebDriver driver;
    WebElement phone;
    WebElement laptop;
    WebElement monitor;
    WebElement add ;
    Alert alert ;

    @BeforeMethod
    public void setupMethod() throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }
        @Test
        public void click () throws InterruptedException {
//• Customer navigation through product categories: Phones, Laptops and Monitors
//            phone = driver.findElement(By.xpath("//a[@id='itemc'][1]"));
//            phone.click();
//            Thread.sleep(2000);
//
//            laptop = driver.findElement(By.xpath("//a[@id='itemc'][2]"));
//            laptop.click();
//            Thread.sleep(2000);
//
//            monitor = driver.findElement(By.xpath("//a[@id='itemc'][3]"));
//            monitor.click();
//            Thread.sleep(2000);
        }
        @Test
        public void navigateLaptop () throws InterruptedException {

            laptop = driver.findElement(By.xpath("//a[@id='itemc'][2]"));
            laptop.click();
            Thread.sleep(2000);

            //• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
            WebElement sonyVioI5 = driver.findElement(By.xpath("//a[@href='prod.html?idp_=8']"));
            sonyVioI5.click();

            add = driver.findElement(By.xpath("//a[@class ='btn btn-success btn-lg']"));
            add.click();

             driver.switchTo().alert().accept();;

        }
        @Test
        public void navigatePhones () throws InterruptedException {
            //• Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart". Accept pop up confirmation.
            phone = driver.findElement(By.xpath("//a[@id='itemc'][1]"));
            phone.click();
            Thread.sleep(2000);
            WebElement samsungGalaxyS6 = driver.findElement(By.xpath("//a[@href='prod.html?idp_=1']"));
            samsungGalaxyS6.click();
             add = driver.findElement(By.xpath("//a[@class ='btn btn-success btn-lg']"));
            add.click();
             driver.switchTo().alert().accept();

        }

        @Test
        public void navigateMonitors() throws InterruptedException {

            //• Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart". Accept pop up confirmation.

            monitor = driver.findElement(By.xpath("//a[@id='itemc'][3]"));
            monitor.click();
            Thread.sleep(2000);

            WebElement appleMonitor = driver.findElement(By.xpath("//a[@href='prod.html?idp_=10']"));
            appleMonitor.click();
             add = driver.findElement(By.xpath("//a[@class ='btn btn-success btn-lg']"));
            add.click();
            driver.switchTo().alert().accept();


        }
    }
