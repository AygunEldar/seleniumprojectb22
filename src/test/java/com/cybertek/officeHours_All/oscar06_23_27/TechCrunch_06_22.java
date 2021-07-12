package com.cybertek.officeHours_All.oscar06_23_27;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TechCrunch_06_22 {

    //1- Go to https://techcrunch.com/
    //2- For “The Latest News” list, verify followings;
    //	a. each news has an author
    //	b. each news has an image
    //3- Click one of news from “The Latest News” list to reach the full content and verify followings;
    //	a. the browser title is the same with the news title
    //	b. the links within the news content
    @Test
    public void tech_cruch() {

        Driver.getDriver().get("https://techcrunch.com/");

        //  List<WebElement> latestNews =Driver.getDriver().findElements(By.xpath("//a[contains(@href,'/author/')]"));
        List<WebElement> latestNews = Driver.getDriver().findElements(By.xpath("//article[@class='post-block post-block--image post-block--unread')]"));
        System.out.println(latestNews.size());
        BrowserUtils.sleep(2);
        for (int i = 0; i <= latestNews.size()-1; i++) {
            String authorLocator = "(//article[@class='post-block post-block--image post-block--unread'])[" + i + "]//a[contains(@aria-label,'Posts by')]";
            WebElement authorElement = Driver.getDriver().findElement(By.xpath(authorLocator));
            Assert.assertTrue(authorElement.isDisplayed());


            String imgLocator = "(//article[@class='post-block post-block--image post-block--unread'])[" + i + "]//img[contains(@sizes,'min-width: 1024px')]";
            WebElement imgElement = Driver.getDriver().findElement(By.xpath(imgLocator));
            Assert.assertTrue(imgElement.isDisplayed());

            // List<WebElement> imgElements = Driver.getDriver().findElements(By.xpath("//]"));

        }
        // //    the browser title is the same with the news title
        //        Random random = new Random();
        //        int newsNumber = random.nextInt(latestNews.size());
        //        latestNews.get(newsNumber).click();
        //        BrowserUtils.sleep(2);
        //        String expectedTitle = Driver.getDriver().findElement(By.xpath("//h1")).getText();
        //        String actualTitle = Driver.getDriver().getTitle();
        //        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //
        //        // the links within the news content
        //
        //List<WebElement> allTheLinksOfTheNews = Driver.getDriver().findElements(By.xpath("//body//a"));
        //Assert.assertTrue(allTheLinksOfTheNews.size()>0);
        //        for (WebElement eachLinksOfTheNew : allTheLinksOfTheNews) {
        //            System.out.println("eachLinksOfTheNew = " + eachLinksOfTheNew.getAttribute("href"));
        //        }
        //
        // Driver.closeDriver();
    }
}