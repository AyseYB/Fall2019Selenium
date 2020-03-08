package com.automation.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LinkedText {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("amount aff all links " + allLinks.size());

        WebElement link = driver.findElement(By.linkText("Autocomplete"));
        link.click();
        Thread.sleep(3000);
        driver.navigate().back();
       //driver.get("http://practice.cybertekschool.com/");
        WebElement checkboxes = driver.findElement(By.linkText("Checkboxes"));
        checkboxes.click();

        Thread.sleep(3000);

        driver.navigate().back();

        WebElement link2 = driver.findElement(By.partialLinkText("Drag"));
        link2.click();
        Thread.sleep(3000);

        driver.close();

//        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
//        System.out.println("Amount of all links" + allLinks.size());



//        WebElement link = driver.findElement(By.linkText("Autocomplete"));
//        link.click();
//
//        Thread.sleep(3000);
//        driver.navigate().back();
//        Thread.sleep(3000);
//
//        WebElement link2 = driver.findElement(By.partialLinkText("Drag"));
//        link2.click();
//        Thread.sleep(3000);
//        driver.close();

    }
}
