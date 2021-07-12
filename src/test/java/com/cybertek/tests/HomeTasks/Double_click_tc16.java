package com.cybertek.tests.HomeTasks;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Double_click_tc16 {
    //TC #16: Double ClickTest

    @Test
    public void tc16clickDouble(){
        // 1.Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        // 2.Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");

        // 3.Double click on the text “Double-click me to change my text color.”


       // WebElement changeMe = Driver.getDriver().findElement(By.linkText("Double-click me to change my text color."));
       // WebElement changeMe = Driver.getDriver().findElement(By.id("demo"));

        WebElement changeMe = Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));


        Actions actions = new Actions(Driver.getDriver());
       //  actions.moveToElement(changeMe).doubleClick().perform();
         actions.doubleClick(changeMe).perform();


        // 4.Assert: Text’s “style” attribute value contains “red”.

       String expectedColor = "red";
    // WebElement color  = Driver.getDriver().findElement(By.xpath("//p[@style='color: red;']"));
   //  String actualColor =color.getAttribute("style");
        
    String actualColor =changeMe.getAttribute("style");

       Assert.assertTrue(actualColor.contains(expectedColor));
    }
}
