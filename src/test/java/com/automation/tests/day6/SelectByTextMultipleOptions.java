package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        BrowserUtils.wait(3);
        //create a webelement object for drop-down first
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        BrowserUtils.wait(3);
        Select languageSelect = new Select(driver.findElement(By.name("Languages")));
        //Whether this select element support selecting multiple options at the same time?
       //This is done by checking the value of the "multiple" attribute.
        boolean isMultiple = languageSelect.isMultiple();  //--> if it's true, you can select more than one option

        System.out.println(isMultiple);

        languageSelect.selectByVisibleText("Java");
        languageSelect.selectByVisibleText("JavaScript");
        languageSelect.selectByVisibleText("Python");

        //let's get all selected options
        List<WebElement> selectedLanguages= languageSelect.getAllSelectedOptions();
        for (WebElement selectedLanguage: selectedLanguages){
            System.out.println("selectedLanguage.getText() = " + selectedLanguage.getText());
        }
        BrowserUtils.wait(2);
        languageSelect.deselectByVisibleText("java"); // to unselect something
        BrowserUtils.wait(3);
        languageSelect.deselectAll();

        BrowserUtils.wait(3);
        driver.quit();
    }
}
