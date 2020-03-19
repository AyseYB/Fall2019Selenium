package com.automation.tests.OfficeHours;

import com.automation.tests.shorts.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGReview {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.out.println("Before test");
        driver = BrowserFactory.getDriver("chrome");

    }

    @AfterMethod
    public void teardown(){
        System.out.println("After method");
        driver.quit();
    }

    @Test(description = "Verify title of google.com", priority = 2)
    public void test1(){
        driver.get("http://google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "title is not correct");
    }

    @Test(description = "Verify title of Apple.com" , priority = 1)
    public void verifyApplesPageTitle(){
        System.out.println("test 2");
        driver.get("https://www.apple.com/");
        String expectedTitle = "Apple";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "title is not correct");
    }
}
