package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TelerikPage {
    public TelerikPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

        @FindBy(id="draggable")
        public   WebElement circle;

    @FindBy(id="droptarget")
    public  WebElement targetCircle;

    @FindBy(id="onetrust-accept-btn-handler")
    public  WebElement acceptCookiesBtn;




}
