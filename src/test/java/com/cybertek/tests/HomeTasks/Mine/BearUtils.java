package com.cybertek.tests.HomeTasks.Mine;

import com.cybertek.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class BearUtils {

    public static void signIn(WebDriver driver) {
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        BrowserUtils.sleep(3);


    }

    public static void printTotal(WebDriver driver) {

        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("Total number of links in current page: " + allLinks);
        for (WebElement each : allLinks) {
            System.out.println(each.getText());

        }
    }

    public static void select(WebDriver driver) {
        // 6.Click on Order
        WebElement orderButton = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderButton.click();

        // 7.Select familyAlbum from product, set quantity to 2

        Select familyAlbum = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));

        familyAlbum.selectByVisibleText("FamilyAlbum");


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
        String state = faker.address().state();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys(state);

        // zipcode locator
        String zipCode = faker.address().zipCode().replace("-", "");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys(zipCode);


        // 10.Click on “visa” radio button

        WebElement visaBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaBtn.click();
        BrowserUtils.sleep(3);
        // 11.Generate card number using JavaFaker
        String cardNum = faker.finance().creditCard().replace("-", "");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(cardNum);

        //additional expire date for the card
        WebElement expDateBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expDateBtn.sendKeys("06/25");
        BrowserUtils.sleep(2);
        // 12.Click on “Process”
        WebElement processBtn = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processBtn.click();

        // 13. Verify success message “New order has been successfully added.”
        WebElement result = driver.findElement(By.xpath("//div[@class='buttons_process']//strong"));
        String expectedText = "New order has been successfully added.";
        String actualText = result.getText();
        Assert.assertEquals(actualText, expectedText);

    }

    public static void click(WebDriver driver) {
//        // 1.3.Enter username: “Tester”
//        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
//
//        // 1.4.Enter password: “test”
//        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");
//
//        // 1.5.Click on Login button
//        driver.findElement(By.xpath("//input[@class='button']")).click();
//        BrowserUtils.sleep(1);

        //3. 2.Click on View all orders
        //  WebElement viewBtn = driver.findElement(By.xpath("//a[@href='Default.aspx']"));

        // 3.Verify Susan McLaren has order on date “01/05/2010”
        WebElement date = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[6]//td[5]"));
        String expected = "01/05/2010";
        String actual = date.getText();
        Assert.assertEquals(actual, expected);

    }
    //task 4
    //PRACTICE #4: Method: verifyOrder
    // •Create a method named verifyOrderin SmartBearUtils class.
    // •Methodtakes WebDriver object and String(name).
    // Methodshould verify if given name exists in orders.
    // •This method should simply accepts a name(String),
    // and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.

    public static void verifyOrder(WebDriver driver, String name) {

        List<WebElement> allOrderNames = driver.findElements(By.xpath("//table[@class='SampleTable']//td[2]"));


        BrowserUtils.sleep(2);
        for (WebElement eachOrderName : allOrderNames) {
            if (eachOrderName.getText().equals(name)) {

                Assert.assertTrue(eachOrderName.getText().equals(name));
            }

        }


    }

    //Task5
    //Practice #5: Method: printNamesAndCities
    // •Create a method named printNamesAndCitiesin SmartBearUtils class.
    // •Method takes WebDriver object.
    // •This method should simply print all the names in the List of All Orders.
    // •Create a new TestNG test to test if the method is working as expected.
    // •Output should be like:•Name1: name , City1: city•Name2: name , City2: city
    public static void printNamesAndCities(WebDriver driver) {

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@class='SampleTable']//tr//td[2]"));
        List<WebElement> allCities = driver.findElements(By.xpath("//table[@class='SampleTable']//tr//td[7]"));


        for (int i =1; i < allNames.size();i++) {
            System.out.println("Name" + i+ ": " + allNames.get(i).getText()+ ", City " + i + ": " + allCities.get(i).getText());

        }
    }
}


