package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://docs.google.com/spreadsheets/d/1jxrPV2YawZnW1AelbK5uviXgLareM5-oq2sn1TGgqFs/edit#gid=1836134997");
        driver.getTitle();
        driver.getCurrentUrl();
        driver.navigate().to("http://amazon.com");
        driver.getTitle();
       // driver.quit();
        driver.close();
    }
}
