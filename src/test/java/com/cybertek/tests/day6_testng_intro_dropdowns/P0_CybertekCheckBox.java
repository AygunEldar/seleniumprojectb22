package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P0_CybertekCheckBox {
    public static void main(String[] args) throws InterruptedException {

        //Practice: Cybertek Checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1. Go to http://practice.cybertekschool.com/checkboxes
        driver.get("http://practice.cybertekschool.com/checkboxes ");
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        // 2. Confirm checkbox #1 is NOT selected by default
        if(!checkBox1.isSelected()){
            System.out.println("CheckBox1 is NOT selected. Verification PASSED.");
        }else{
            System.out.println("CheckBox1 is selected. Verification FAILED.");
        }

        //3. Confirm checkbox #2 is SELECTED by default.
        if(checkBox2.isSelected()){
            System.out.println("CheckBox2 is  selected. Verification PASSED.");
        }else{
            System.out.println("CheckBox2 is NOT selected. Verification FAILED.");
        }
        //4. Click checkbox #1 to select it.
        Thread.sleep(2000);
        checkBox1.click();

        //5. Click checkbox #2 to deselect it.
        Thread.sleep(2000);
        checkBox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        if(checkBox1.isSelected()){
            System.out.println("CheckBox1 is  selected. Verification PASSED.");
        }else{
            System.out.println("CheckBox1 is NOT selected. Verification FAILED.");
        }
        //7. Confirm checkbox #2 is NOT selected.
        if(!checkBox2.isSelected()){
            System.out.println("CheckBox2 is NOT selected. Verification PASSED.");
        }else{
            System.out.println("CheckBox2 is selected. Verification FAILED.");
        }
        driver.close();
    }

}
