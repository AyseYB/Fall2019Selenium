package com.automation.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtonPractice {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
//        Thread.sleep(3000);
//        driver.findElement(By.id("yellow")).click();
//        Thread.sleep(3000);
//        driver.navigate().forward();
//
//        driver.findElement(By.id("red")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.id("green")).click();

        List<WebElement> radioButtons = driver.findElements(By.className("input"));
        System.out.println("radio buttons " + radioButtons.size());
        driver.quit();
    }
}
