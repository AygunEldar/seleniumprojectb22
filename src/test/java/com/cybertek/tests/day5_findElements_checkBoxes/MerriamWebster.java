package com.cybertek.tests.day5_findElements_checkBoxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MerriamWebster {
    public static void main(String[] args) {

        //TC #0: FINDELEMENTS
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2.Go to https://www.merriam-webster.com/
        driver.get("https://www.merriam-webster.com/");
        
        // 3.Print out the texts of all links
        List<WebElement>listOfAllLinks =driver.findElements(By.xpath("//body//a"));

        int countMissingText =0;
        int countWithText =0;

        for(WebElement each : listOfAllLinks){
            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));


            if(each.getText().isEmpty()){
                countMissingText++;
            }else{
                countWithText++;
            }
        }
        // 4.Print out how many link is missing text
        System.out.println(countMissingText +" links are missing text");//22

        // 5.Print out how many link has text
        System.out.println(countWithText + " links have text");//142
        
        // 6.Print out how many total link
        int numberOfTotalLinks =listOfAllLinks.size();
        System.out.println("numberOfTotalLinks = " + numberOfTotalLinks);//164

    }
}
