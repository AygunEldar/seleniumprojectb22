package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractice {

    @Test
    public void dynamic_loading_7Test(){
        //TC#40 : Dynamically Loaded Page Elements 7


        //1. Go to http://practice.cybertekschool.com/dynamic_loading/
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");

        //2. Wait until title is “Dynamic title”
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);

        //use the object to wait for the explicit condition
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //this will wait until the image is displayed on the page
      //  wait.until(ExpectedConditions.visibilityOf(DynamicLoad7Page().imageOfSpongeBob));

        //3. Assert : Message “Done” is displayed.
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());

        //4. Assert : Image is displayed.
        Assert.assertTrue(dynamicLoad7Page.imageOfSpongeBob.isDisplayed());
    }
}
