package com.cybertek.tests.HomeTasks.Mine;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader_again {


   private static Properties properties =new Properties();
   static {

       FileInputStream fileInputStream = null;
       try {
           fileInputStream = new FileInputStream("configuration.properties");

           properties.load(fileInputStream);
           fileInputStream.close();
       } catch (IOException e) {
           e.printStackTrace();
           System.out.println("File is not found");
       }


   }
   public  static String getProperty(String keyword){
       return properties.getProperty(keyword);
   }


    }




