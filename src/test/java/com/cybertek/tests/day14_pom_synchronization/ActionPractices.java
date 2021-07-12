package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionPractices {
    //TC #16: Hover Test
    // 1.Go to https://demos.telerik.com/kendo-ui/dragdrop/index
    // 2.Drag and drop the small circle to bigger circle.
    // 3.Assert:
    // -Text in big circle changed to: “You did great!”

    @Test
    public void drag_and_drop_TC17() {

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        TelerikPage telerikPage = new TelerikPage();

        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(2);
        //accept cookies button
        telerikPage.acceptCookiesBtn.click();
             BrowserUtils.sleep(2); //////////


       actions.dragAndDrop(telerikPage.circle, telerikPage.targetCircle).perform();// short way

   //actions.moveToElement(telerikPage.circle).dragAndDrop(telerikPage.circle,telerikPage.targetCircle).perform();

 //actions.moveToElement(telerikPage.circle).clickAndHold(telerikPage.circle)
       //  .moveToElement(telerikPage.targetCircle).release().perform();//long way

        String expectedText = "You did great!";

        String actualText = telerikPage.targetCircle.getText();
        Assert.assertEquals(actualText,expectedText);

    }

}