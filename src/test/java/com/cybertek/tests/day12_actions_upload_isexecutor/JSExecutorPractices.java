package com.cybertek.tests.day12_actions_upload_isexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorPractices {
    @Test
    public void scroll_using_jsExecutor_test1(){

        //Get the page:http://practice.cybertekschool.com/infinite_scroll
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");


    //Down Casting our driver type to JavascriptExecutor so we can reach method in this interface
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //((JavascriptExecutor) Driver.getDriver()).executeScript();



        //using js we reach executeScript method so we are allowed to pass Javascript functions
        // this method is capable accepting JavaScript functions and apply that into  our Java+Selenium code
//        js.executeScript("window.scrollBy(0,750)");
//        js.executeScript("window.scrollBy(0,750)");

        //in each iteration it will scroll  750 pixel DOWN
        for(int i  =0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");

        }
        //this line will go 750 pixel UP
        js.executeScript("window.scrollBy(0,750)");
    }

    @Test
    public void scroll_using_jsExecutor_test2(){

        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        JavascriptExecutor js =(JavascriptExecutor) Driver.getDriver();


             //locating the WebElements so we use in js js.executorScript method
        WebElement  cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement  homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        //use js.executor with different scrolling JavaScript function
        BrowserUtils.sleep(1);
        //scroll down to cybertek school link
        js.executeScript("arguments[0].scrollIntoView(true)",cybertekSchoolLink);

         BrowserUtils.sleep(1);
        //scroll up Home link
        js.executeScript("arguments[0].scrollIntoView(true)",homeLink);

    }
}
