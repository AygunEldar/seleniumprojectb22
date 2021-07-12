package com.cybertek.utilities;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {



    private static Properties properties = new Properties();

    static{

        try {
            FileInputStream file = new FileInputStream("configuration.properties");


//                Java FileInputStream class obtains input bytes from a file.
//                It is used for reading byte-oriented data (streams of raw bytes) such as image data,
//                audio, video etc. You can also read character-stream data.


            properties.load(file);
            file.close();

        } catch (IOException e) {


            System.out.println("File not found in configuration");
        }

        finally {
            System.out.println("Finally Block. Properties File Has been Initiated and Initialization Finished.");
        }


    }
    public static String getProperty(String keyword){

//            return keyword;
        return properties.getProperty(keyword); //this is the correct one

    }


}

