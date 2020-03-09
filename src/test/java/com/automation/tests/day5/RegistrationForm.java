package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(5);
        //enter firstname
        driver.findElement(By.name("firstname")).sendKeys("John");
        //enter lastName
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        //enter username
        driver.findElement(By.name("username")).sendKeys("jsmith");
        //enter email
        driver.findElement(By.name("email")).sendKeys("jsmith@email.com");
        //enter password
        driver.findElement(By.name("password")).sendKeys("secret");
        //enter phone
        driver.findElement(By.name("phone")).sendKeys("312-863-1484");
        //select gender
        List<WebElement> genders= driver.findElements(By.name("gender"));
        //select gender
        genders.get(1).click();
        //enter birthdate
        driver.findElement(By.name("birthday")).sendKeys("01/01/2007");
        //select programing language
        driver.findElement(By.id("inlineCheckbox2")).click();//select java

        //enter sign up
        driver.findElement(By.id("wooden_spoon")).click(); // select submit

        BrowserUtils.wait(2);




        driver.quit();
    }
}
