package com.cybertek.tests.AZEgroup;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase {
   BluePrint object = new BluePrint();

    @BeforeClass
    public void setDriver(){
        object.url ="http://practice.cybertekschool.com/javascript_alerts";
        object.impTime=10;
        object.getDriver(object.impTime);
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        object.tearDown();
    }
    @Test
    public void jcPromptTest() throws InterruptedException {
        object.jsPrompt= "//button[.='Click for JS Prompt']";
        object.enteredText= "murtuz";
        object.resultXpath="//p[@id='result']";
        Assert.assertTrue( object.jsPrompt().contains(object.enteredText));

    }
}
