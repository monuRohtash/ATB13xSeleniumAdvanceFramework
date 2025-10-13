package com.thetestingacademy.pages.pageFactory.IDrive360;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage_PF_IDRIVE extends CommonToAllPage {

    WebDriver driver;

    public DashBoardPage_PF_IDRIVE(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Example: dashboard heading or logo after login
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement dashboardTitle;
//




    public boolean isDashboardDisplayed() {

        return isDisplayed(dashboardTitle);

    }

}
