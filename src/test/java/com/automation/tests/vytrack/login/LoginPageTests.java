package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.jvm.hotspot.utilities.Assert;

//STATIC IMPORT OF ALL ASSERTIONS
import static org.testng.Assert.*;
public class LoginPageTests {
    private WebDriver driver;
    private String username = "storemanager85";
    private String password = "UserUser123";
    //https is a secured version of http protocol
    //http - it's hypertext transfer protocol that every single website is using now days
    //https - data encrypted, no chance for hackers to retrieve info
    //http - data as a plain text, very easy to hack it
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.cssSelector("[class='alert alert-error']");

    @Test(description = "verify that warning message displays when user enters invalid username")
    public void invalidUserName(){
        driver.findElement(usernameBy).sendKeys("invalidusername", Keys.ENTER);
        driver.findElement(passwordBy).sendKeys("userUSer123", Keys.ENTER);
        BrowserUtils.wait(5);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual, expected);

    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDOwn(){
        //if webdriver object alive
        if(driver !=null){
            //to close browser
            driver.quit();
            //destroy driver object for sure
            driver = null;
        }
    }
}