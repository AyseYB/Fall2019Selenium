package com.automation.tests.shorts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorPracticewithXpath {

    public static void main(String[] args) throws Exception{

       WebDriver driver = BrowserFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com");
       WebElement headerText = driver.findElement(By.xpath("//span[@class='h1y']"));
       Thread.sleep(3000);
        System.out.println("H1 text : " + headerText.getText());


     //  driver.navigate().back(); // i cannot go back because i am already at the home page
       WebElement contextMenu = driver.findElement(By.xpath("//a[.='Context Menu']"));
       contextMenu.click();
       Thread.sleep(3000);

       driver.navigate().back();
       WebElement dragDrop = driver.findElement(By.xpath("//a[@href='/drag_and_drop']"));
       dragDrop.click();
       Thread.sleep(3000);

       driver.navigate().back();
       WebElement registration = driver.findElement(By.tagName("h2"));
       registration.click();
       WebElement gender= driver.findElement(By.xpath("//input[@value='male']"));
       gender.click();
        System.out.println("it is clicked");

       Thread.sleep(3000);

       driver.quit();
    }
}
