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

public class RegistrationForm2 {
    private String URL ="http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By userNameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");
    private By birthdayBy = By.name("birthday");
    private By departmentBy= By.name("department");
    private By job_TitleBy = By.name("job_title");
    private By cplusplusBy = By.id("inlineCheckbox1");
    private By javaBy = By.id("inlineCheckbox2");
    private By javaScriptBy = By.id("inlineCheckbox3");
    private By signUpBy = By.id("wooden_spoon");

    @Test
    public void test1(){
        driver.findElement(firstNameBy).sendKeys("Ayse");
        driver.findElement(lastNameBy).sendKeys("YB");
        driver.findElement(userNameBy).sendKeys("#");
        BrowserUtils.wait(3);
        WebElement warningMessage=driver.findElement(By.xpath("//small[text()='The username must be more than 6 and less than 30 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @Test
    public void firtsNameLengthTest(){
        driver.findElement(firstNameBy).sendKeys("A");
        WebElement warningMessage= driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @Test
    public void verifyAlphabeticLetterOnlyTest(){
        driver.findElement(firstNameBy).sendKeys("123");
        WebElement warningMessage=driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
