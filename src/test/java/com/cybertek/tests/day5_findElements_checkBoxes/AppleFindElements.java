package com.cybertek.tests.day5_findElements_checkBoxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppleFindElements {
    public static void main(String[] args) {

        //TC #02: FINDELEMENTS_APPLE
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
        // 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // 3.Click to iPhone
       WebElement iphone = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iphone.click();
        // 4.Print out the texts of all links

        List<WebElement>listOfAllLinksText = driver.findElements(By.xpath("//body//a"));
         int countMissingText = 0;
         int countWithText = 0;
         for(WebElement each :listOfAllLinksText ){
             System.out.println(each.getText());
             System.out.println(each.getAttribute("href"));

             if(each.getText().isEmpty()){
                 countMissingText++;

             }else{
                 countWithText++;
             }

         }
        // 5.Print out how many link is missing text
        System.out.println(countMissingText + " links are missing text");//55

        // 6.Print out how many link has text
        System.out.println(countWithText + " links have text");//153

        // 7.Print out how many total link
        int numberOfTotalLinks = listOfAllLinksText.size();
        System.out.println("numberOfTotalLinks = " + numberOfTotalLinks);//208
    }

}
