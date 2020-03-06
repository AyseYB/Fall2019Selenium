package com.automation.tests.warm_up;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class March_4 {
 static WebDriver driver;
    public static void main(String[] args) {
        ebayTest();
        amazonTest();
        vikiTest();

    }
    //Go to ebay
//enter search term
//click on search button
//print number of results
    public static void ebayTest(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement result = driver.findElement(By.tagName("h1"));
     //   System.out.println(result.getText().split(" ")[0]);
        System.out.println(result.getText());

        driver.quit();



    }

    //go to amazon
//enter search term
//click on search button
//verify title contains search term
    public static void amazonTest(){

    }
    public static void vikiTest(){

    }

}
//Go to ebay
//enter search term
//click on search button
//print number of results
//go to amazon
//Go to ebay
//enter search term
//click on search button
//verify title contains search term
//Go to wikipedia.org
//enter search term `selenium webdriver`
//click on search button
//click on search result `Selenium (software)`
//verify url ends with `Selenium_(software)`