package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alert3 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //    TC #3: Information alert practice
//1. Open browser
//2. Go to website: http://practice.cybertekschool.com/javascript_alerts
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }
  @Test
  public void click(){
      // 3. Click to “Click for JS Prompt” button
      WebElement infoClickBtn =driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
      infoClickBtn.click();

      Alert alert = driver.switchTo().alert();
     // alert.accept();
      alert.sendKeys("hello");
  }


//4. Send “hello” text to alert
//5. Click to OK button from the alert
//6. Verify “You entered: hello” text is displayed
}
