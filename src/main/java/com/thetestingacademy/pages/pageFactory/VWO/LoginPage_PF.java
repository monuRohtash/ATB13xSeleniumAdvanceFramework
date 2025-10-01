package com.thetestingacademy.pages.pageFactory.VWO;


import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class LoginPage_PF extends CommonToAllPage {

    WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

//    private By username = By.id("login-username");
//    private By password = By.id("login-password");
//    private By signButton = By.id("js-login-btn");
//    private By error_message = By.id("js-notification-box-msg");

     // This A Page Factory
     @FindBy(id = "login-username")
     private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;



    // Page Actions

    public String loginToVWOLoginInvalidCreds_PF(String user, String pwd) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);


        // ✅ Explicit wait for error message to appear
        wait.until(ExpectedConditions.visibilityOf(error_message));

        return getText(error_message);
    }

    public void loginToVWOLoginValidCreds_PF(String user, String pwd) {

        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);

        // Wait - Thread sleep
        WaitHelpers.waitJVM(5000);

    }





}
