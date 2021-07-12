package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadPage {

    public DynamicLoadPage(){

        PageFactory.initElements(Driver.getDriver(),this);


    }
   @FindBy(xpath = "//button[.='Start']")
    public WebElement startBtn;

    @FindBy(id = "loading")
    public  WebElement loadingBar;

    @FindBy(id="username")
    public  WebElement inputUsername;

    @FindBy(id = "pwd")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Submit']")
    public  WebElement submitButton;

    @FindBy(id = "flash")
    public  WebElement errorMessage;

    //
}

