package com.automation.tests.OfficeHours;

import com.automation.tests.shorts.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorsReview {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "verifyCheckBoxes")
    public void test1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        WebElement checkBox1 = driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
        //how to verify if check box is not cliked?
        Assert.assertFalse(checkBox1.isSelected());

        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(checkBox2.isSelected(), "Checkbox2 was not selected");
    }
    @Test
    public void test2(){
        driver.findElement(By.linkText("Radio Buttons")).click();
        WebElement blueButton = driver.findElement(By.id("blue"));
        blueButton.click();
        Assert.assertTrue(blueButton.isSelected());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
