package com.cybertek.tests.AZEgroup.suleyman;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FixedTableAcademyObj {
    //https://www.rahulshettyacademy.com/AutomationPractice/
    //scroll ele Web Table Fixed header web elemente
    //ordan table icinde amoutnlari hesabla
    //table asagisina yazilib 296 onun ile assert ele


    @Test
    public static void table(){
        Driver.getDriver().get("https://www.rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js =(JavascriptExecutor) Driver.getDriver();
               js.executeScript("window.scrollBy(0,750)");

       AcademyPage webTable = new AcademyPage();


        List<WebElement> allAmount =webTable.allAmount;

               int allTotalCount =0;
        for(WebElement each : allAmount){

          //  System.out.println(each.getText());

            int allCount = Integer.parseInt(each.getText());
             allTotalCount += allCount;

        }
           // System.out.println(allTotalCount);

       String actual = String.valueOf(allTotalCount) ;
       String expected = webTable.totalAmountCollected.getText();

       Assert.assertTrue(expected.contains(actual));

       // System.out.println(expected);
   }
}
