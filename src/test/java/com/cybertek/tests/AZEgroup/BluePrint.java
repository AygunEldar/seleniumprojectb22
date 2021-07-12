package com.cybertek.tests.AZEgroup;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BluePrint {
    WebDriver driver;
    WebElement jsPromptAlert;
    String url;
    int impTime;
    String jsPrompt;
    String enteredText;
    String resultXpath;
    String displayedMessage;

    public void getDriver(int impTime) {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(impTime, TimeUnit.SECONDS);
        driver.get(url);

    }
    public String jsPrompt() throws InterruptedException {
        jsPromptAlert = driver.findElement(By.xpath(jsPrompt));
        jsPromptAlert.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys(enteredText);
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        return displayedMessage = driver.findElement(By.xpath(resultXpath)).getText();

    }
    public void tearDown(){

        driver.close();
    }
}
