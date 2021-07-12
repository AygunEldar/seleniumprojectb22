package com.cybertek.tests.day10_webtable_propertiespracties;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//TC#6: Cybertek registration form confirmation
// Note: Use JavaFaker when possible.
// 1.Open browser
// 2.Go to website: http://practice.cybertekschool.com/registration_form
// 3.Enter first name
// 4.Enter last name
// 5.Enter username
// 6.Enter email address
// 7.Enter password
// 8.Enter phone number
// 9.Select a gender from radio buttons
// 10.Enter date of birth
// 11.Select Department/Office
// 12.Select Job Title
// 13.Select programming language from checkboxes
// 14.Clickto sign up button
// 15.Verify success message “You’ve successfully completed registration.”is displayed.
public class CybertekRegistration {

    WebDriver driver;


    @BeforeMethod
@Test
    public void setup() {

        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("urlTest2");

        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);


        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
      // WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));

        String lastName = faker.name().lastName();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);


//        String userName = faker.;
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);

//        String emailAddress = faker.address().fullAddress();
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailAddress);

        String password = faker.address().fullAddress();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        String phone = faker.phoneNumber().cellPhone();
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);


       WebElement gender= driver.findElement(By.xpath("//input[@name='gender']"));
       gender.sendKeys();

     //  String dateOfBirth = faker.date().;


    }
}
