package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {
    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By userNameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("\"input[value='other']\"");
    private By dateOfBirthdayBy = By.name("birthday");
    private By depatartmenBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    private By cplusplusBy = By.cssSelector("input[value='cplusplus']");
    private By javaBy = By.cssSelector("input[value='java']");
    private By javaScriptBy = By.cssSelector("input[value='javascript']");
    private By signUpBy = By.id("wooden_spoon");

    @Test
    public void test1(){
        driver.findElement(firstNameBy).sendKeys("Patrick");
        driver.findElement(lastNameBy).sendKeys("White");
        driver.findElement(userNameBy).sendKeys("testuser");
        driver.findElement(emailBy).sendKeys("test@email.com");
        driver.findElement(passwordBy).sendKeys("1234556767");
        driver.findElement(phoneBy).sendKeys("238-466-4574");
        driver.findElement(femaleBy).click();
        driver.findElement(dateOfBirthdayBy).sendKeys("01/01/1940");

        Select departmentSelect = new Select(driver.findElement(depatartmenBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        BrowserUtils.wait(4);

        String expected ="You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void verifyFirstNameLengthTest(){
        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warningMessage =
                driver.findElement(By.xpath
                        ("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @BeforeMethod

    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyAlphabeticLettersOnlyTest(){
        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtils.wait(3);
       WebElement warningMessage=
               driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
       Assert.assertTrue(warningMessage.isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
