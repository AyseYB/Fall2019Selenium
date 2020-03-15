package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//####TASK for 10 minutes: until 4:17
//Create a class called PracticeTests
//- setup before/after methods
//	- in before method. instantiate webdriver and navigate to:
//	http://practice.cybertekschool.com/
//	- in after method - just close webdriver.
//- create a test called lofinTest
//	- go to “Form Authentication” page
//	- enter valid credentials
//	- verify that following sub-header message is displayed:
//	“Welcome to the Secure Area. When you are done click logout below.”

public class PracticeTests {

    private WebDriver driver;


    /**
     * We put @Test annotation to make methods executable as tests
     */
    @Test
    public void loginTest(){
        driver.findElement(By.partialLinkText("Form Authentication")).click();
        BrowserUtils.wait(4);
        //	- enter valid credentials
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword",Keys.ENTER);
//	- verify that following sub-header message is displayed:
//	“Welcome to the Secure Area. When you are done click logout below.”
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actual, expected);

    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
