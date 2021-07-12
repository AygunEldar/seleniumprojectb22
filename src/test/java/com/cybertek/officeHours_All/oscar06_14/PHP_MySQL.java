package com.cybertek.officeHours_All.oscar06_14;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PHP_MySQL {
    //1. Go to http://thedemosite.co.uk/login.php page, check the page whether opened or not
//2. Check the following elements on login page;
//a. Tab Title = 'Login example page to test the PHP MySQL online system'
//b. Header = '4. Login'
//c. Status Message = No login attempted
//d. Info Message = 'Enter your login details you added on the previous page and test
//the login. The success or failure will be shown above.'
//e. Username field
//f. Password password field
//g. Test Login button
//3. Perform a successful login and check the status message change
//4. Perform a failed login and check the status message change
    WebDriver driver;

    @BeforeMethod

    public void setup() {

        String browser = ConfigurationReader.getProperty("browser");


        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(" http://thedemosite.co.uk/login.php ");
    }
        @Test
        public void login(){

            String expected = "Login example page to test the PHP MySQL online system";
            String actual = driver.getTitle();

            Assert.assertEquals(actual, expected);

    }
    @Test
    public void checkHeader(){

        String actualHeader = driver.findElement(By.xpath("//strong[.='4. Login']")).getText();
        String expectedHeader = "4. Login";

    }
    @Test
    public void statusMessage(){

        String actualMessage = driver.findElement(By.xpath("//b[.='**No login attempted**']")).getText();
        String expectedMessage ="No login attempted";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void infoMessage(){

        String expectedMessage = "Enter your login details you added on the previous page and test\n" +
                "//the login. The success or failure will be shown above.";
        String actualMessage = driver.findElement(By.xpath("(//p[align='center'])[6]")).getText();

        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public  void  fieldUser_Password(){

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        Faker faker =  new Faker();
        String usN = faker.name().username();
        userName.sendKeys(usN);
       // userName.sendKeys("fdgghgfhgf");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        String pWord = faker.name().username();
        password.sendKeys(pWord);
       // password.sendKeys("dfgdfg");

        WebElement testBtn = driver.findElement(By.xpath("//input[@name='FormsButton2']"));
        testBtn.click();
    }
    @Test
    public  void loginFailed () {

        WebElement failed = driver.findElement(By.xpath("//center//b[.='**Failed Login**']"));

        String expectedFail = "**Failed Login**";
        String actualFail = failed.getText();
        Assert.assertEquals(actualFail, expectedFail);
    }
        @Test
        public void loginSuccess(){

        WebElement success = driver.findElement(By.xpath("//center//b[.='**Successful Login**']"));

        String expectedSuc = "**Successful Login**";
        String actualSuc = success.getText();
        Assert.assertEquals(actualSuc,expectedSuc);
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(2);
    }
}