package com.cybertek.tests.HomeTasks;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Context_TC17 {

    //TC #17: Context Click –HOMEWORK
    // 1.Go to https://the-internet.herokuapp.com/context_menu
    // 2.Right click to the box.
    // 3.Alert will open.
    // 4.Accept alertNo assertion needed for this practice.
    @Test
    public void context_TC(){

       Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        Actions actions  =new Actions(Driver.getDriver());

        WebElement square = Driver.getDriver().findElement(By.id("hot-spot"));
         actions.contextClick(square).perform();

//       WebElement alertBtn =Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Alert']"));
        BrowserUtils.sleep(5);
        Alert alert = Driver.getDriver().switchTo().alert();
              alert.accept();



    }
}
