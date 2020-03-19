package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTests2 {
    private WebDriver driver;
    private String URL = "http://practice.cybertekschool.com/";

    @Test
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        String expected = "Welcome to the Secure Area. When you are done click logout below.\n";
        String actual =driver.findElement(By.className("subheader")).getText();
        BrowserUtils.wait(4);
        Assert.assertEquals(actual, expected);
    }
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver =new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
