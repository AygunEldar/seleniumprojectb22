package com.cybertek.tests.day12_actions_upload_isexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTest {

    //TC #14: UploadTest


    @Test
    public void upload_test(){

        // 1.Go to http://practice.cybertekschool.com/upload
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        // 2.Find some small file from your computer, and get the path of it.
                String path = "C:\\Users\\elkha\\Pictures\\Saved Pictures\\image_50388481.JPG";

        // 3.Upload the file.
        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));  //Gurhan 1
        //Sending the file path to the chosenFile WebElement
        chooseFile.sendKeys(path);                                                    //Gurhan 3


        BrowserUtils.sleep(3);
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit")); //Gurhan 2

        //click upload button
       uploadButton.click();                                                           //Gurhan 4

        // 4.Assert:
        // -File uploaded text is displayed on the page
        WebElement fileUploadedMessage  =Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedMessage.isDisplayed());

    }

}
