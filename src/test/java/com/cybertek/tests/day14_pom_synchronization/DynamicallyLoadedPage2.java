package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DynamicallyLoadedPage2 {
    //TC#41 : Dynamically Loaded Page Elements 1


    @Test
    public void DynamicallyLoaded_7_test(){


    }
    @Test
    public  void dynamic_loading_1_test(){

//1. Go to http://practice.cybertekschool.com/dynamic_loading/1
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        DynamicLoadPage dynamicLoadPage =new DynamicLoadPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


        //2. Click to start
        dynamicLoadPage.startBtn.click();

        //3. Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoadPage.loadingBar));

        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoadPage.inputUsername.isDisplayed());

        //5. Enter username: tomsmith
        dynamicLoadPage.inputUsername.sendKeys("tomsmith");

        //6. Enter password: incorrectPassword
        dynamicLoadPage.inputPassword.sendKeys("incorrectPassword");

        //7. Click to Submit button
        dynamicLoadPage.submitButton.click();

        //8. Assert “Your password is invalid!” text is displayed.
      //  wait.until(ExpectedConditions.visibilityOf(dynamicLoadPage.errorMessage));
        Assert.assertTrue(dynamicLoadPage.errorMessage.isDisplayed());


    }
    @AfterMethod
    public  void tearDownMethod(){
        Driver.closeDriver();
    }

}
