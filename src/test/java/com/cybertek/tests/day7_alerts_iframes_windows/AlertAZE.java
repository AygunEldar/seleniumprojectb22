package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AlertAZE {
    //TC #1: Information alert practice
    //1. Open browser
    //2. Go to website: http://practice.cybertekschool.com/javascript_alerts

    //4. Click to OK button from the alert
    //5. Verify “You successfuly clicked an alert” text is displayed.

    WebDriver driver;
    WebElement infoAlertButton;
      WebElement resultText;
       String url;
       String jsButton;
       String displayedMessage;
       String actualText;
       String result;
    String expectedText;
    int impTime;

 public void getUp(int impTime) {

     driver = WebDriverFactory.getDriver("chrome");
     driver.manage().window().maximize();
     driver.get(url);
     driver.manage().timeouts().implicitlyWait(impTime, TimeUnit.SECONDS);

 }

 public  WebElement jsButton() throws InterruptedException {
     infoAlertButton =driver.findElement(By.xpath(jsButton));
     infoAlertButton.click();
     Alert alert = driver.switchTo().alert();
     Thread.sleep(5000);
     alert.accept();
    // Thread.sleep(5000);
     jsButton().click();

      expectedText = "You successfuly clicked an alert";
     actualText = resultText.getText();
     //Assert.assertTrue(resultText.isDisplayed());
     return null;
 }


}
