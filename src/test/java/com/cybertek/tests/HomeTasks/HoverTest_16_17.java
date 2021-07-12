package com.cybertek.tests.HomeTasks;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest_16_17 {
     WebDriver driver;
    //TC #16: Hover Test
    // 1.Go to https://demos.telerik.com/kendo-ui/dragdrop/index
    // 2.Drag and drop the small circle to bigger circle.
    // 3.Assert:
    // -Text in big circle changed to: “You did great!”

    @Test
    public void drag_and_drop_TC17(){

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
  WebElement cookies =Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
  cookies.click();

        WebElement targetCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement circle = Driver.getDriver().findElement(By.id("draggable"));


        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(circle).dragAndDrop(circle,targetCircle).perform();

         String expectedText = "You did great!";

         String actualText = targetCircle.getText();
        Assert.assertEquals(actualText,expectedText);



    }
}
