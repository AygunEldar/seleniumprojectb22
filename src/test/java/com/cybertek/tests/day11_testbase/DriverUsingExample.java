package com.cybertek.tests.day11_testbase;

import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class DriverUsingExample {
    @Test
    public void  how_to_use_driver(){

        Driver.getDriver().get("http://library2.cybertekschool.com/login.html");
    }
}
