package com.thetestingacademy.pages.pageObjectModel.vwo.Prop_POM;

import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_Proper_Pom {
    WebDriver driver;

    // Page Class

    // Step 0 -  Param Constructor
    public LoginPage_Proper_Pom(WebDriver driver){
        this.driver = driver;
    }

    // Step 1- Page Locators
    private final By username = By.id("login-username");
    private final By password = By.id("login-password");
    private final By signButton = By.id("js-login-btn");
    private final By error_message = By.id("js-notification-box-msg");

    // If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");

    // Step 2 - Page Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        WaitHelpers.checkVisibility(driver,error_message);
        return driver.findElement(error_message).getText();

    }

    public void loginToVWOLoginValidCreds(String user, String pwd) {
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        // Wait - Thread sleep
        WaitHelpers.waitJVM(5000);
    }

}
