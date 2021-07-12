package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4_AZE {
//TC #4: Selecting value from multiple select dropdown
// 1.Open Chrome browser
// 2.Go to http://practice.cybertekschool.com/dropdown
// 3.Select all the options from multiple select dropdown.
// 4.Print out all selected values.
// 5.Deselect all values.

    WebDriver driver;
    String url;
    String multipleDropdown;

    @Test
    public void Test4() {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
            }
//      public List<String>dropdown(){
//          WebElement language =driver.findElement(By.xpath(multipleDropdown));
//          Select select =new Select(language);
//         // List<WebElement>
//      }

}