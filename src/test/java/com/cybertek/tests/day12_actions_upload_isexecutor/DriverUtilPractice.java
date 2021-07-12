package com.cybertek.tests.day12_actions_upload_isexecutor;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilPractice {
    @Test
    public void simple_google_search_test(){


        // 1- Go to google.com
       // Driver.getDriver(); = driver --> creates driver instance and ready to use
        Driver.getDriver().get(ConfigurationReader.getProperty("googleUrl"));

        //2- Search for a value
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

       //String searchValue = "there is no spoon"
        String searchValue = ConfigurationReader.getProperty("searchValue");


        //send the searchValue and press Enter
        searchBox.sendKeys(searchValue+ Keys.ENTER);

        //3- Verify value is contained in the title
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = searchValue;

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // This will terminate the session and assign driver value to null
     Driver.closeDriver();

     Driver.getDriver().get("https://etsy.com");

        Driver.closeDriver();
    }
}
