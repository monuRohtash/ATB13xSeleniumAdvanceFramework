package com.thetestingacademy.pages.pageFactory.OHRM;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class LoginPage_PF_Ohr extends CommonToAllPage {

    WebDriver driver;
    // Constructor
    public LoginPage_PF_Ohr(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "input[placeholder='Username']")
    private WebElement usernameInput;

    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()=\"Invalid credentials\"]")
    private WebElement error_msg;


    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));


    // Actions / Methods
    public String loginInValid_Hrm(String user , String pwd){
        openOrangeHRMUrl();

//        wait.until(ExpectedConditions.visibilityOf(usernameInput));
//        wait.until(ExpectedConditions.visibilityOf(passwordInput));
//        wait.until(ExpectedConditions.visibilityOf(loginButton));


        enterInput(usernameInput,user);
        enterInput(passwordInput,pwd);
        clickElement(loginButton);

        wait.until(ExpectedConditions.visibilityOf(error_msg));
        return getText(error_msg);

        }

    public void LoginToHrmValidCreds_PF(String user, String pwd){


        openOrangeHRMUrl();
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));

        enterInput(usernameInput,user);
        enterInput(passwordInput,pwd);
        clickElement(loginButton);
    }

}
