package com.automation.tests.shorts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeCSS {

    public static void main(String[] args) throws Exception{

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("James");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Bond");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("JamesB");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("jbond@cybertek.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("1a2b3c4d");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("777-777-7777");
        Thread.sleep(1000);
        driver.findElement( By.cssSelector("input[value='male']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/10/1990");
        Thread.sleep(1000);
        Select selectDep = new Select(driver.findElement(By.cssSelector("select[name='department']")));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("option[value='DE']"));
        Thread.sleep(1000);
        Select select = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        Thread.sleep(1000);
        select.selectByVisibleText("Designer");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id='inlineCheckbox2']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);

        driver.quit();

    }
}
