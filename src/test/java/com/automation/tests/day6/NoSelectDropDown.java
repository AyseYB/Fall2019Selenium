package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropDown {

    public static void main(String[] args) {

       WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click(); // to expand dropdown

        BrowserUtils.wait(3);
      //  driver.findElement(By.linkText("Google")).click();
     //   BrowserUtils.wait(2);
     //   driver.navigate().back();
       // driver.findElement(By.id("dropdownMenuLink")).click();

      //  driver.findElement(By.linkText("Etsy")).click();
 BrowserUtils.wait(3);
        List<WebElement> links = driver.findElements(By.className("dropdown-item"));
        for(WebElement eachLink : links){
            System.out.println(eachLink.getText()+ " : " + eachLink.getAttribute("href"));
        }

        BrowserUtils.wait(3);
        driver.quit();




    }
}
