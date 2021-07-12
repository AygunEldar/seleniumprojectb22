package com.cybertek.tests.AZEgroup;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtils {
    public static void logIn(WebDriver driver){
        // 3.Enter username: “Tester”
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");
        // 4.Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        // 5.Click to Login button
        WebElement loginButton= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
        // Mini-Task:CREATE A CLASS àSmartBearUtils
        // •Create a method called loginToSmartBear
        // •This method simply logs in to SmartBear when you call it.
        // •Accepts WebDriver type as parameter
    }
    public static void printAllLinks(WebDriver driver){
        // 6.Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("allLinks.size() = " + allLinks.size());
        //7. Print out each link text on this page
        for (WebElement each : allLinks) {
            System.out.println(each.getText());
        }
    }

    public static void order(WebDriver driver){
        // 6.Click on Order
        WebElement orderButton = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderButton.click();

        // 7.Select familyAlbum from product, set quantity to 2
        Select productDropDown = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        productDropDown.selectByVisibleText("FamilyAlbum");

        WebElement quantityButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantityButton.sendKeys("2");

        // 8.Click to “Calculate” button
        WebElement calculateBotton = driver.findElement(By.xpath("//input[@type='submit']"));
        calculateBotton.click();

        // 9.Fill address Info with JavaFaker•Generate: name, street, city, state, zip code
        Faker faker = new Faker();

        String name = faker.name().fullName();

        WebElement nameLocate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        nameLocate.sendKeys(name);

        String street = faker.address().streetAddress();
        WebElement streetLocate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        streetLocate.sendKeys(street);

        String city = faker.address().cityName();
        WebElement cityLocate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        cityLocate.sendKeys(city);

        String state = faker.address().state();
        WebElement stateLocate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        stateLocate.sendKeys(state);

        String zipCode = faker.address().zipCode().replaceAll("-", "");
        WebElement zipCodeLocate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipCodeLocate.sendKeys(zipCode);

        // 10.Click on “visa” radio button
        WebElement visaButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaButton.click();

        // 11.Generate card number using JavaFaker
        String cardNumber = faker.finance().creditCard().replace("-", "");
        WebElement cardNumberButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumberButton.sendKeys(cardNumber);
        WebElement expireDatelocate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expireDatelocate.sendKeys("09/25");

        // 12.Click on “Process”
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 13.Verify success message “New order has been successfully added.”
        WebElement result =driver.findElement(By.xpath("//div[@class='buttons_process']//strong"));
        String expectedText ="New order has been successfully added.";
        String actualText = result.getText();
        Assert.assertEquals(actualText,expectedText);
    }
}

