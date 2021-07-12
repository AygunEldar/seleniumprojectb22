package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task5 {
    //TC #5: Selecting value from non-select dropdown
// 1.Open Chrome browser
    WebDriver driver;
    String a ;
    String b;
    String url;
    String expected;
    WebElement nonSelectedDrop;

    public void getUp(int waitTime){
      driver = WebDriverFactory.getDriver("chrome");
      driver.manage().window().maximize();
driver.get(url);
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
public String nonSelectedDropDown1(){
   // 3.Click to non-select dropdown
   nonSelectedDrop.findElement(By.xpath(a));
   nonSelectedDrop.click();

  WebElement facebook = driver.findElement(By.xpath(b));
   facebook.click();
   String actual = driver.getTitle();
   return actual;
}

//WebElement facebook =driver.findElement(By.xpath(""));



}

