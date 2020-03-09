package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //## TASK
        // verify that 1st checkbox is not selected and 2nd is selected

        BrowserUtils.wait(2);
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("Test Passed");
        }else {
            System.out.println("test failed");
        }
        // LETS CLICK ON THE FIRST CHECK BOX AND VERIFY ITS CLICKED
        BrowserUtils.wait(2);
     //   checkBoxes.get(0).click(); // to get first checkbox OR
        WebElement checkBox1 = checkBoxes.get(0); // to get first checkbox
        checkBox1.click(); //click on it

        BrowserUtils.wait(2);
        if(checkBox1.isSelected()){
            System.out.println("test passed");
            System.out.println("checkBox1 is selected");
        }else {
            System.out.println("test failed");
            System.out.println("heckbox.get(0) is not selected");
        }

        driver.quit();
    }
}
