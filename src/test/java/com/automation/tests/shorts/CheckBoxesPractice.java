package com.automation.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesPractice {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        //find all elements with tag name input
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        //loop through this list of elements
        for (WebElement checkBox : checkBoxes){
            Thread.sleep(3000);
            //if checkbox is not selected yet
            if(!checkBox.isSelected()){
                //select it
                checkBox.click();
            }
        }
        driver.quit();
    }
}
