package com.cybertek.tests.day12_actions_upload_isexecutor;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test(priority = 2)
    public void singleton_understanding_test1(){

//if str runs first the rest already has value
        //
        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2= " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);
    }

    @Test(priority = 1)
    public void singleton_test2(){

        // if str runs alone it is ---> the first .......
        //if all class runs ----> already has........

        String str4 = Singleton.getWord();
        System.out.println("str4 = " + str4);
    }
}
