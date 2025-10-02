package com.thetestingacademy.pages.pageFactory.OHRM;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage_PF_Ohr extends CommonToAllPage {

    WebDriver driver;
    // Constructor
    public LogOutPage_PF_Ohr(WebDriver driver) {
        super();                   // CommonToAllPage का constructor call होगा (waits included)
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p.oxd-userdropdown-name")
    private WebElement userProfileDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutButton;


    @FindBy(xpath = "//h5[text()=\"Login\"]")
    private WebElement login;


    public String logoutUser() {
        clickElement(userProfileDropdown);
        clickElement(logoutButton);
        return getText(login);

    }
}
