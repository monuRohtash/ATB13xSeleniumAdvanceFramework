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

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class LoginPage_PF_IDRIVE extends CommonToAllPage {

    public LoginPage_PF_IDRIVE(WebDriver driver) {
        super();              // CommonToAllPage का constructor call होगा (waits included)
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

    @FindBy(xpath = "//p[contains(text(),'Email address or password you entered is incorrect')]")
    WebElement error_msg;



    public void idriveValidLogin(String email, String password){

        openIDriveUrl();
        enterInput(emailInput,email);
        enterInput(passwordInput,password);
        clickElement(signingBTN);

    }


    public String idriveINvalidLogin(String email, String password){

//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

        openIDriveUrl();
        enterInput(emailInput,email);
        enterInput(passwordInput,password);
        clickElement(signingBTN);
        // ✅ Explicit wait for error message to appear
//        wait.until(ExpectedConditions.visibilityOf(error_msg));
        return getText(error_msg);

    }



















}
