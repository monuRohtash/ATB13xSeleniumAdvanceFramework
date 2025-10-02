package com.thetestingacademy.pages.pageFactory.VWO;

import com.thetestingacademy.base.CommonToAllPage;

import com.thetestingacademy.utils.WaitHelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage_PF extends CommonToAllPage {

    WebDriver driver;

    public DashBoardPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    private final By userNameOnDashboard = By.xpath("//h6");

    // This A Page Factoryimport org.openqa.selenium.support.ui.WebDriverWait;

    @FindBy(xpath = "//h6")
    private WebElement userNameOnDashboard_pf;

    // Page Actions
    public String loggedInUserName() {
        WaitHelpers.waitJVM(10000);
        return getText(userNameOnDashboard_pf);

    }

}
