package com.cybertek.tests.HomeTasks.Mine;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Reading_Properties_2 {
    @Test
    public void reading_properties_again() throws IOException {

        Properties properties =new Properties();
        FileInputStream fileInputStream =new FileInputStream("configuration.properties");

        properties.load(fileInputStream);



        System.out.println("properties.getProperty() = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty() = " + properties.getProperty("searchValue"));

    }






}
