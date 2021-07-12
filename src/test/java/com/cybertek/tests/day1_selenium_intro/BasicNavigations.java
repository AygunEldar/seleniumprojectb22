package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //1-set up the driver
        WebDriverManager.chromedriver().setup();

        //2-creat instance of selenium web driver
        // this line opens a browser
        WebDriver driver = new ChromeDriver();

        //this line will maximize the browser size;
        driver.manage().window().maximize();

        // MAC users
        //driver.manage().window().fullscreen();

        //3- get the page
        driver.get("https://www.tesla.com");
        
        System.out.println("Current title: "+driver.getTitle());

       String currentUrl =  driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        
         //putting 3 seconds to wait/ stops the code for 3 seconds
        Thread.sleep(3000);

        //Going back using navigattions
        driver.navigate().back();

        //putting 3 seconds to wait/ stops the code for 3 seconds
        Thread.sleep(3000);

        //Going forward using navigations
        driver.navigate().forward();

        //putting 3 seconds to wait/ stops the code for 3 seconds
        Thread.sleep(3000);

        //refreshing the page using navigations
        driver.navigate().refresh();

        //putting 3 seconds to wait/ stops the code for 3 seconds
        Thread.sleep(3000);

        //going to another URL using  .to() method
        driver.navigate().to("https://www.google.com");


        System.out.println("Current title " + driver.getTitle());

        currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

        //this method will close  the currently open one browser or 1 tab

        driver.close();

        //will close all of the opened browsers or tabs within the same session
        driver.quit();


    }
}
