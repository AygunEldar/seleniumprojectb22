package com.cybertek.officeHours_All.oscar06_23_27;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.OfficeHoursUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon {
@Test
        public void login(){
    //1.	Go to https://www.amazon.com
    Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    //2.	Create a DashBoard POM containing tabs that are DISPLAYED (Not All- I added this)

    AmazonPage amazonPage =new AmazonPage();

    for (int i = 0; i <amazonPage.tabList.size() ; i++) {
        String text= amazonPage.tabList.get(i).getText();
        amazonPage.Tab(text).click();

    }
    //3.	Search for "hats for men" (call from Configuration properties)
    amazonPage.searchLine.sendKeys(ConfigurationReader.getProperty("searchInAmazon")+ Keys.ENTER);
    amazonPage.searchBtn.click();


    //4.	Add the first hat appearing to Cart with quantity 2

    amazonPage.firstHat.click();
    String priceText =amazonPage.singlePrice.getText();

    double singlePriceForHat = OfficeHoursUtils.priceConverter(priceText);
    Select selectQuan =new Select(amazonPage.quantityDropDown);
    selectQuan.selectByVisibleText("2");

    //5.	Open cart and assert that the total price and quantity are correct
    amazonPage.qntBtn.click();

    amazonPage.qnt_2.click();
    amazonPage.addBtn.click();
    amazonPage.cartBtn.click();

    Assert.assertTrue(amazonPage.subTotalText.getText().contains("2 items"));

    double priceForTwo = Double.parseDouble(amazonPage.subTotalAmount.getText().substring(2));
    Assert.assertTrue(2 * singlePriceForHat == priceForTwo);


//    String expectedPrice = "27.80";
//    String actualPrice = amazonPage.totalPrice.getText();
//    Assert.assertEquals(actualPrice,expectedPrice);

//    String expectedNumber = "2";
//    String actualNumber = amazonPage.numberOfQnt.getText();
//    Assert.assertEquals(actualNumber,expectedNumber);

    //6.	Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3
        selectQuan.selectByVisibleText("1");
  //  amazonPage.cart.click();
    Assert.assertTrue(amazonPage.subTotalText.getText().contains("1 item"));
    double priceForOne = Double.parseDouble(amazonPage.subTotalAmount.getText().substring(2));

    //7.	Assert that the total price and quantity has been correctly changed

    Assert.assertTrue(priceForTwo/priceForOne==2);
}


}
