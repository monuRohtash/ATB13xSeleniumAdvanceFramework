package com.thetestingacademy.pages.pageFactory.IDrive360;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage_PF_IDRIVE extends CommonToAllPage {

    public LogOutPage_PF_IDRIVE(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;


    // ✅ Logout Button (top-right user menu or direct link)
    @FindBy(xpath = "//a[normalize-space()='J']")
    WebElement Profiledrp;


    // ✅ Logout Button (top-right user menu or direct link)
    @FindBy(xpath = "//a[@title=\"Logout\"]")
    WebElement logoutButton;

    // ✅ Logout Success Message (appears after successful logout)
    @FindBy(xpath = "//h1[normalize-space()='Sign in to IDrive 360']")
    WebElement logoutSuccessMsg;


    // ---------- Actions ----------


    public String logoutUserDrive() {
        clickElement(Profiledrp);
        clickElement(logoutButton);
        return getText(logoutSuccessMsg);

    }


}
