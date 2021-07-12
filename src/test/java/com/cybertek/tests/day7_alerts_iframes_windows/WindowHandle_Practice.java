package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowHandle_Practice {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
//    TC # : Window Handle practice
//1. Create a new class called: WindowHandlePractice
//2. Create new test and make set ups


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //3. Go to : http://practice.cybertekschool.com/windows
        driver.get("http://practice.cybertekschool.com/windows");
    }
    @Test
            public void window_test(){

        //printing out the window handle of the first page  opened
        //Storing the first windowHandle into a string is a useful practice for future needs when we need
        //to switch back to it
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        // 4. Assert: Title is “Practice”
        String actualTitleBeforeClick = driver.getTitle();
        String expectedTitleBeforeClick = "Practice";

        System.out.println("actualTitleBeforeClick"+ actualTitleBeforeClick);

        // 5. Click to: “Click Here” text
    WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
    clickHereLink.click();

    for(String each : driver.getWindowHandles()){
        driver.switchTo().window(each);
        System.out.println("Current tile while switching " + driver.getTitle());
        //if(driver.getTitle().contains("something")){}
    }

        String actualTitleAfterClick = driver.getTitle();

        System.out.println("actualTitleAfterClick = " + actualTitleAfterClick);



       //6. Switch to new Window.

      //7. Assert: Title is “New Window”


    }
}