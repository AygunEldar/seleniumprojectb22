package com.cybertek.tests.HomeTasks;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTask2 {
    //TC#2: Smartbear software order placing
    // 1.Open browser
    // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

       WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }
    @Test
    public void loginPage () {
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@class='button']")).click();
BrowserUtils.sleep(3);

        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("Total number of links in current page: " +allLinks);
        for (WebElement each : allLinks) {
            System.out.println(each.getText());

        }

    }
    @Test
    public void logInPage()  {


        // 7.Select familyAlbum from product, set quantity to 2

 WebElement selectProBtn = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select familyAlbum = new Select(selectProBtn);
        familyAlbum.selectByIndex(1);
        selectProBtn.click();

        WebElement quantity = driver.findElement(By.xpath("//input[@id ='ctl00_MainContent_fmwOrder_txtQuantity']"));
             quantity.clear();
            quantity.sendKeys("2");

        // 8.Click to “Calculate” button
       WebElement calcBtn = driver.findElement(By.xpath("//input[@type='submit']"));
       calcBtn.click();

        // 9.Fill address Info with JavaFaker•
        // Generate: name, street, city, state, zip code
        Faker faker = new Faker();

           //name locator
        String customerName = faker.name().firstName();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys(customerName);
   //WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys(customerName);
  // customerName.send.Keys(customerName);

            //street locator
        String street = faker.address().streetName();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")).sendKeys(street);

         //city locator
         String city = faker.address().cityName();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys(city);

          //state locator
        String state =faker.address().state();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys(state);

           // zipcode locator
        String zipCode =faker.address().zipCode().replace("-","");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys(zipCode);


        // 10.Click on “visa” radio button

  WebElement visaBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
       visaBtn.click();
        BrowserUtils.sleep(3);
        // 11.Generate card number using JavaFaker
        String cardNum = faker.finance().creditCard().replace("-","");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(cardNum);

        //additional expire date for the card
       WebElement expDateBtn= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expDateBtn.sendKeys("06/25");
        BrowserUtils.sleep(2);
        // 12.Click on “Process”
        WebElement processBtn = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
           processBtn.click();

        // 13. Verify success message “New order has been successfully added.”
        WebElement result =driver.findElement(By.xpath("//div[@class='buttons_process']//strong"));
        String expectedText ="New order has been successfully added.";
        String actualText = result.getText();
        Assert.assertEquals(actualText,expectedText);

    }

    @AfterMethod
    public void teardownClass() throws InterruptedException {
        BrowserUtils.sleep(3);
        driver.close();

    }
}