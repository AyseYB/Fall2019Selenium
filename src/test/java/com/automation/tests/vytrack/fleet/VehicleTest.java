package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//######## TASK
//under fleet package create a class called VehiclesPageTests
//In this class, you will need to create @beforemethod with setup and @aftermethod with teardown part. Use LoginPageTests class as a reference.
//create a test called verifyPageSubTitle
//	- in this test, you will need to navigate to Fleet --> Vehicles and verify that page subtitle is equals to “All Cars”
//	user assertions for validation.
//######

public class VehicleTest {
    private WebDriver  driver;
    private String URL ="https://qa2.vytrack.com/";

    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(), 'Fleet')]");
    private By subTitleBy = By.className("oro-subtitle");
    private By pageNumberBy = By.cssSelector("input[type='number']");



    @Test
    public void verifyPageSubtitle(){
        //login
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(5);
        //click on fleet
        //driver.findElement(fleetBy).click();
        //Actions class is used for more advanced browser interaction
        Actions actions = new Actions(driver);
        //move to element instead of clicking
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        //perform - to execute command
        //every action should end with perform()
        BrowserUtils.wait(2);
        //click on vehicles
        driver.findElement(By.linkText("Vehicles")).click();

        BrowserUtils.wait(4);
//find subtitle element
        WebElement subtitleElement = driver.findElement(subTitleBy);
        System.out.println(subtitleElement.getText());

        String expected = "All Cars";
        String actual = subtitleElement.getText();

        Assert.assertEquals(actual, expected);

    }

//    *     ################ TASK 7 minutes until 3:48
//            *
//            *     Given user is on the vytrack landing page
//     *     When user logs on as a store manager
//     *     Then user navigates to Fleet --> Vehicles
//     *     And user verifies that page number is equals to "1"
//     */
    @Test
    public void verifyPageNumber(){
        String expected ="1";
        String actual = driver.findElement(pageNumberBy).getAttribute("value");

        Assert.assertEquals(actual, expected);
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(5);
        //click on fleet
        //driver.findElement(fleetBy).click();
        //Actions class is used for more advanced browser interaction
        Actions actions = new Actions(driver);
        //move to element instead of clicking
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        //perform - to execute command
        //every action should end with perform()
        BrowserUtils.wait(2);
        //click on vehicles
        driver.findElement(By.linkText("Vehicles")).click();

    }

    @AfterMethod
    public void tearDown(){
        if(driver != null ){
            driver.quit();
        }
    }
}
