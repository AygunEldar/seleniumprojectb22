package com.cybertek.officeHours_All.oscar06_23_27;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "nav-a  ")
    public List<WebElement> tabList;

    public WebElement Tab (String text){
        String locator ="//a[.=\""+text+"\"]";
        return Driver.getDriver().findElement(By.xpath(locator));
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchLine;

    @FindBy(id="nav-search-submit-button")
    public WebElement searchBtn;

  @FindBy(xpath = "(//div[@class='a-section a-spacing-medium a-text-center'])[1]")
    public WebElement firstHat;

  WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    public void setWait(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(firstHat)).click();
    }
    @FindBy(id="price-inside_buybox")
    public WebElement singlePrice;

    @FindBy (xpath = "//select[@name='quantity']")
    public WebElement quantityDropDown;


    @FindBy(xpath ="//span[@class='nav-cart-icon nav-sprite']")
    public WebElement cart;

  @FindBy(xpath = "//span[@class='a-dropdown-label']")
    public WebElement qntBtn;

  @FindBy(xpath = "//a[@id='quantity_1']")
    public WebElement qnt_2;

  @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addBtn;

  @FindBy(xpath = "//a[@id='hlb-view-cart-announce']")
    public WebElement cartBtn;

    @FindBy(css = "#sc-subtotal-label-activecart")
    public WebElement subTotalText;

    @FindBy(css = "#sc-subtotal-amount-activecart")
    public WebElement subTotalAmount;

//  @FindBy(xpath = "//a-column a-span2 a-text-right sc-item-right-col a-span-last")
//  public WebElement expPrice;

  @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']']")
    public WebElement totalPrice;

  @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    public WebElement numberOfQnt;


}
