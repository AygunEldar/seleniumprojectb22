package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_from_properties_file() throws IOException {

        // #1- create object of Properties class(coming from Java Lib)

        Properties  properties = new Properties();

        // # 2- open the file using FileInputStream
        //We are trying to open a file, so we need to pass the path

       FileInputStream file = new FileInputStream("configuration.properties");

       // #3 Load the properties object with our file
        properties.load(file);

        // #4 reading from configuration properties, it will return googe.com
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"dataTablesUrl\") = " + properties.getProperty("dataTablesUrl"));

    }
    @Test
    public void using_properties_method(){

        ConfigurationReader.getProperty("browser");
        ConfigurationReader.getProperty("env");
        ConfigurationReader.getProperty("username");
        System.out.println("ConfigurationReader.getProperty(\"browser\")"+ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"env\") = " + ConfigurationReader.getProperty("env"));
        System.out.println("ConfigurationReader.getProperty(\"username\") = " + ConfigurationReader.getProperty("username"));
        System.out.println("ConfigurationReader.getProperty(\"dataTablesUrl\") = " + ConfigurationReader.getProperty("dataTablesUrl"));
    }
}
