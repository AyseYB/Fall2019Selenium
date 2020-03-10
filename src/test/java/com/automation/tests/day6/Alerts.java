package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click(); // to click the first button
        BrowserUtils.wait(3);
        //to get the text from pupUP message
        String pupUpText = driver.switchTo().alert().getText();
        System.out.println(pupUpText);

        driver.switchTo().alert().accept(); //to click ok

        String expected = "You succesfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        //it will fail, because there is a ###BUG###
        System.out.println("TEST #1");
        if(expected.equals(actual)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
        BrowserUtils.wait(3);

//#######################################################################################
        System.out.println("TEST #2");

        buttons.get(1).click();//to click on the 2nd button
        BrowserUtils.wait(3);
        //to click cancel
        driver.switchTo().alert().dismiss();

        String expected2= "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
            System.out.println("expected2 = " + expected2);
            System.out.println("actual2 = " + actual2);
        }
//######################################################################################
        System.out.println("TEST #3");
        //TASK for 5 minutes until 3:37: click on button #3
        //Enter some text: Hello, World!
        //Verify that result text ends with Hello, World!

        buttons.get(2).click();

        BrowserUtils.wait(3);

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Hello World"); // enter text
        BrowserUtils.wait(3);

        alert.accept();//click ok

        String actual3 = driver.findElement(By.id("result")).getText();
        String expected3 = "Hello World";
        if(actual3.endsWith(expected3)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
            System.out.println("actual3 = " + actual3);
            System.out.println("expected3 = " + expected3);
        }





        BrowserUtils.wait(3);
        driver.quit();
    }
}
