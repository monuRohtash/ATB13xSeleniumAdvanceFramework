package com.thetestingacademy.pages.pageFactory.VWO;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage_PF extends CommonToAllPage {

    WebDriver driver;

    public LogOutPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

//    private final By userLogOut_drop = By.xpath("//button[@aria-label='Open user menu']");
//    private final By logout_btn = By.xpath("//*[text()='Logout']");
//    private final By VerifyLogin_Page_Text = By.xpath("//*[text()=\"Sign in to VWO platform\"]");


    @FindBy(xpath = "//button[@aria-label='Open user menu']")
    private WebElement userLogOut_drop;

    @FindBy(xpath = "//*[text()='Logout']")
    private WebElement logout_btn;

    @FindBy(xpath = "//*[text()=\"Sign in to VWO platform\"]")
    private WebElement VerifyLogin_Page_Text;


    public String logoutUser() {

        clickElement(userLogOut_drop);
        clickElement(logout_btn);
        return (VerifyLogin_Page_Text).getText();


        // Wait - Thread sleep


    }


}
