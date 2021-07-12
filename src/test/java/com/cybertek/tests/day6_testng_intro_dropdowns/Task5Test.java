package com.cybertek.tests.day6_testng_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task5Test {


        Task5 tc = new Task5();
        // 2.Go to http://practice.cybertekschool.com/dropdown


        @BeforeClass
    public void setUp(){
            tc.url = "http://practice.cybertekschool.com/dropdown";
            tc.getUp(10);
        }
    @Test
    public void nonSelectDropDown(){
tc.a =//a[@id='dropdownMenuLink']" ;
tc.b = //a[@id='dropdown-item'][4]";
tc.expected = "Facebook -Log In or Sign Up";
String actual =tc.nonSelectedDropDown1();
        System.out.println(actual);
        Assert.assertEquals(actual,tc.expected);
            //  tc.driver.findElement(By.xpath(""));
// 4.Select Facebook from dropdown
// 5.Verify title is “Facebook -Log In or Sign Up”
    }
//
  //  @AfterClass

   // driver.quit();
}
