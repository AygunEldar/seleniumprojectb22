package com.cybertek.tests.HomeTasks;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Again_UpLoad {

    //1.Go to http://practice.cybertekschool.com/upload
    @Test
    public void upLoad() {
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        // 2.Find some small file from your computer, and get the path of it.
        String myComp = "C:\\Users\\elkha\\Pictures\\Flags.PNG";

        WebElement uploadBtn = Driver.getDriver().findElement(By.id("file-upload"));//xpath-?
        WebElement submitBtn = Driver.getDriver().findElement(By.id("file-submit"));

        // 3.Upload the file.
        uploadBtn.sendKeys(myComp);
        BrowserUtils.sleep(2);
        submitBtn.click();
        // 4.Assert: -File uploaded text is displayed on the page
        WebElement text =Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(text.isDisplayed());
    }
}