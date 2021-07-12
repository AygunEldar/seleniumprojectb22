package com.cybertek.tests.day10_webtable_propertiespracties;


import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Table_Tasks_Tests extends TestBase{

//    TC#3: WebTable order verification
//
//
//
//    1.    Open browser and go to: http://practice.cybertekschool.com/tables#edit
//            2.    Locate first table and verify Tim has due amount of “$50”
//
//    Note: Create locator for Tim that will be dynamic and doesn’t care in which row Tim is.


    @Test

    public void testCheck() {

     String url =ConfigurationReader.getProperty("urlTest");
             driver.get(url);
       // driver.get(ConfigurationReader.getProperty("urlTest"));

        ////table[@id='table1']//td[.='Tim'] --> this locator locates Tim's cell regardless
        // of which row he is in

        //2.	Locate first table and verify Tim has due amount of “$50”

        // 1st way: //table[@id='table1']//td[.='Tim']/../td[4]
        // 2nd way: //table[@id='table1']//td[.='Tim']/following-sibling::td[2]



        //Note: Create locator for Tim that will be dynamic and doesn’t care in which row Tim is.


        WebElement timsDue = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/../td[4]"));
        System.out.println("timsDue = " + timsDue.getText());

        String actualTimResult = timsDue.getText();
        String expected = "$50.00";

        Assert.assertEquals(actualTimResult, expected);


    }

    @Test

    public void verify_task4_order_method(){

        String url =ConfigurationReader.getProperty("urlTest");
        driver.get(url);


        TableUtils.verifyOrder(driver, "Tim");

    }
    @Test
         public void task5_Name_Email(){

        String url =ConfigurationReader.getProperty("urlTest");
        driver.get(url);

             TableUtils.printNamesAndEmails(driver);
         }
}

