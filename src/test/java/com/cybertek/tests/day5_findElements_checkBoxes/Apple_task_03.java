package com.cybertek.tests.day5_findElements_checkBoxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Apple_task_03 {
    public static void main(String[] args) {
        //TC #03: FINDELEMENTS_APPLE
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // 3.Click to all of the headers one by one
        //             a.Mac, iPad, iPhone, Watch, TV, Music, Support

        List<WebElement>headerLinks =driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));

        for(int eachLink =1; eachLink < headerLinks.size()-1; eachLink++){

           // System.out.println(headerLinks.get(eachLink).getText());
            headerLinks.get(eachLink).click();
            headerLinks =driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));

        }
        // 4.Print out the titles of the each page
        System.out.println("Current title in the page: " +driver.getTitle());

        // 5.Print out total number of links in each page
      List<WebElement>allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("Total number of links in current page: " +allLinks);

        // 6.While in each page:
        int countLinkMissingTextTotal =0;
        int countLinkHasTextTotal= 0;

        for (WebElement each : allLinks) {
         //   System.out.println(each.getText());
         //  System.out.println(each.getAttribute("href"));
            if(each.getText().isEmpty()){
                countLinkMissingTextTotal++ ;
            }else{
                countLinkHasTextTotal++;
            }
        }
        //     a.Print out how many link is missing textTOTAL
        System.out.println("Links with NO text " +countLinkMissingTextTotal);

        //     b.Print out how many link has textTOTAL
        System.out.println("Links with text " +countLinkHasTextTotal);

    }
}
