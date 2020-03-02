package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{
        //to start selenium script we need:
        //setUp webdriver (browser driver ) and create webdriver object
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //in selenium everything starts from WebDriver Interface
        //ChromeDriver extends RemoteWebDrivet --->webdriver object
        driver.get("http://google.com"); // to open a website
        Thread.sleep(3000);
        //method that return page title
// you can also see it as tab name, in the browser
        String title = driver.getTitle(); // returns <title> some title</title> text
        String expectedTitle = "Google";
        System.out.println("title is ... " + title);
        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        //MUST BE AT THE END
        driver.close();// to close browser

    }
}
