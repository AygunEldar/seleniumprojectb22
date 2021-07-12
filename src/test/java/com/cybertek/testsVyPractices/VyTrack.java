package com.cybertek.testsVyPractices;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrack {

@BeforeMethod
@ Test
        public void setup() throws InterruptedException {
    Driver.getDriver().get("browser");

           Driver.getDriver().get("https://qa3.vytrack.com/user/login");

            Driver.getDriver().manage().window().maximize();

           Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']")).sendKeys("user45");

            WebElement passWord = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
            passWord.sendKeys("UserUser123" + Keys.ENTER);

            Driver.getDriver().navigate().refresh();

            WebElement eventBtn = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-1']"));
            eventBtn.click();

            Thread.sleep(2000);
    //            //driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-0']")).click();
    ////    WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
    ////    fleet.click();
    //

    WebElement vehicle = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-2']"));
    vehicle.click();
//      WebElement vehicleBtn = driver.findElement(By.xpath("//i[@class='fa-asterisk menu-icon']"));
//
//     vehicleBtn.click(


}
        @Test
        public void vy_dropdown_test(){
//            Select vehicleBtn = new Select(driver.findElement(By.xpath("//i[@class='fa-asterisk menu-icon']")));
//            String actualDropdown = vehicleBtn.getFirstSelectedOption().getText();
//            String expectedDropdown = "Vehicle";
//            Assert.assertEquals(actualDropdown,expectedDropdown);
        }
    }


