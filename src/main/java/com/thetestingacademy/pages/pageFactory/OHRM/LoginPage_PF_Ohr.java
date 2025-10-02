package com.thetestingacademy.pages.pageFactory.OHRM;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage_PF_Ohr extends CommonToAllPage {

    WebDriver driver;
    // Constructor
    public LoginPage_PF_Ohr(WebDriver driver) {
        super();                   // CommonToAllPage का constructor call होगा (waits included)
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // Locators
    @FindBy(css = "input[placeholder='Username']")
    private WebElement usernameInput;

    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()=\"Invalid credentials\"]")
    private WebElement error_msg;



    // Invalid Login
    public String loginInValid_Hrm(String user , String pwd){
        openOrangeHRMUrl();                 // URL open
        enterInput(usernameInput, user);    // CommonToAllPage helper
        enterInput(passwordInput, pwd);
        clickElement(loginButton);

        return getText(error_msg);           // Wait + getText
    }

    // Valid Login
    public void loginValid_Hrm(String user, String pwd){
        openOrangeHRMUrl();                 // URL open
        enterInput(usernameInput, user);    // CommonToAllPage helper
        enterInput(passwordInput, pwd);
        clickElement(loginButton);
    }


}
