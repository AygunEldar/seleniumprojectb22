package com.cybertek.tests.AZEgroup.suleyman;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AcademyPage {
    public AcademyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//legend[.='Web Table Fixed header']")
    public WebElement webTableHeader;


    @FindBy(xpath ="//div[@class='tableFixHead']")
    public WebElement smallTable;

    @FindBy(xpath = "//div[@class='totalAmount']")
    public WebElement totalAmount;

    @FindBy(xpath = "//table[@id='product']//tr/td[4]")
    public List<WebElement> allAmount;

   @FindBy(xpath = "//div[.=' Total Amount Collected: 296 ']")
    public WebElement totalAmountCollected;
}