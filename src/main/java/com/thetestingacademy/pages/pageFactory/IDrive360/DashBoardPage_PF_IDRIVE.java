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

//    //   dashboard  -> Payment Information
//    @FindBy(xpath = "//*[text()=\"Payment Information\"]")
//    private WebElement Payment_Information;



    public boolean isDashboardDisplayed() {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

        // Wait for both elements together
//        wait.until(ExpectedConditions.visibilityOfAllElements(Payment_Information));
        // Using && ensures that both elements must be visible for the method to return true.
//        return isDisplayed(dashboardTitle) && isDisplayed(Payment_Information);
        WaitHelpers.waitJVM(3000);
        return isDisplayed(dashboardTitle);


    }

}
