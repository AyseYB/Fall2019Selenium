package com.automation.tests.vytrack.activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

/**
 * TASK until 8:14
 *
 * Scenario: Verify for store manager
 *
 * Login as story manager
 * Go to Activities --> Calendar Events
 * Verify that Create Calendar Event button is displayed
 */

public class CalenderEventsPageTest {
    private By usernameBy= By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;

    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword="UserUser123";
    private  By activitiesBy = By.linkText("Activities");
    private By createCalenderEventBy = By.linkText("Calendar Events");

}
