package com.cybertek.tests.day7_alerts_iframes_windows;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertTest {



    AlertAZE  newAlert = new AlertAZE();


    @BeforeClass
    public void setUp(){
        newAlert.url =" http://practice.cybertekschool.com/javascript_alerts";
       newAlert.impTime = 25;
       newAlert.getUp(newAlert.impTime);

    }
    @Test
    public void jsButtonTest(){
  newAlert.jsButton ="//button[.='Click for JS Alert']";

        newAlert.result= "//p[@id='result']";
        Assert.assertEquals(newAlert.actualText,newAlert.expectedText);

    }

    @AfterClass
    public void teardownClass(){

        //newAlert.driver.close();
    }
}
