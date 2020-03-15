package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTesNGTest {

    //Runs only once in the class before @beforemethod and before any test
    //regardless on number of tests, it runs only once
    @BeforeClass
    public void beforeClass(){
        //something that should be done only once in the class BEFORE all tests
        System.out.println("BEFORE CLASS");
    }

    @AfterClass
    public void afterClass(){
//something that should be done only once in the class after all tests
        System.out.println("AFTER CLASS");
    }

    //runs before every test automatically
    //works as a pre-condition or setup
    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }

    //runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("After Method");
    }

    @Test
    public void test1(){
        System.out.println("Test 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
        int num = 5;
        int num1 = 10;
        //it calls hard assertion.
        //if assertion fails - it stops the execution (due to exception).
        Assert.assertTrue(num < num1);
    }
}
