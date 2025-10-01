package com.thetestingacademy.pages.pageFactory.IDrive360;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_PF_IDRIVE extends CommonToAllPage {

    public LoginPage_PF_IDRIVE(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebDriver driver;


    @FindBy(id="username")
    WebElement emailInput;

    @FindBy(id="password")
     WebElement passwordInput;

    @FindBy(xpath="//button[@type=\"submit\"]")
    WebElement signingBTN;


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public void idriveValidLogin(String email, String password){

        openIDriveUrl();

        wait.until(ExpectedConditions.visibilityOf(emailInput));
        enterInput(emailInput,email);
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        enterInput(passwordInput,password);
        clickElement(signingBTN);

    }


















}
