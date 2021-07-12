package com.cybertek.tests.day9_properties_browser_utils;

import org.testng.annotations.Test;

public class Learning_Properties {
    @Test
    public void java_properties_reading_test(){

        System.out.println("System.getProperties(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    }
}
