package com.automation.tests.OfficeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelaniumOH2 {

    public static void main(String[] args) throws Exception{

        /**
         1. go to http://automationpractice.com
         2. search for "tshirt" in a search box + click enter or click search button
         3. validate you got "no result" message on UI
         4. search for "t-shirt"
         5 validate there was 1 result found
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("tshirt" + Keys.ENTER);
        Thread.sleep(3000);
        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        String errorText = error.getText();
        System.out.println("Error message" + errorText);
        //NoSuchElementExeption - it means we could not locate the element

        WebElement search_box = driver.findElement(By.id("search_query_top"));
        search_box.clear();
        search_box.sendKeys("t-shirt" + Keys.ENTER);
        Thread.sleep(3000);
        WebElement count = driver.findElement(By.className("product-count"));
        System.out.println("item found :"+  count.getText());

        driver.quit();


    }
}
