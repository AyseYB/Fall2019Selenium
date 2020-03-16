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

import java.util.List;
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

    /*
    Task
    Given user is on the practice landing page
    When user navigates to "forgot Password" page
    Then user enters his email
    and click "retrieve password" button
    Then user verifies that message "Your email's beem sent!" is displayed.
     */

    @Test
    public void forgotPasswordTest(){
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(4);
        driver.findElement(By.name("email")).sendKeys("testemail@email.com", Keys.ENTER);
        BrowserUtils.wait(4);

        String actual =driver.findElement(By.name("confirmation_message")).getText();
        String expected = "Your e-mail's been sent!";
        Assert.assertEquals(actual,expected, "Confirmation message is not valid");

    }

        /*
    Task
    Given user is on the practice landing page
    When user navigates to "CHeckBoxes" page
And click on checkBox #1
    Then user verifies that checkbox #1 is selected
     */
        @Test
        public void checkBoxTest1(){
            driver.findElement(By.linkText("Checkboxes")).click();
            BrowserUtils.wait(4);
            WebElement checkbox1 =driver.findElement(By.xpath("//input[@type='checkbox']"));
            checkbox1.click();
            Assert.assertTrue(checkbox1.isSelected());

            //Second Way
            //collect all checkboxes
//            List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
//            BrowserUtils.wait(4);
//            checkBoxes.get(0).click(); // to click

            //how to verify same checkbox is selected
            //   Assert.assertTrue(checkBoxes.get(0).isSelected(), "Checkboz #1 is not selsected!");

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
