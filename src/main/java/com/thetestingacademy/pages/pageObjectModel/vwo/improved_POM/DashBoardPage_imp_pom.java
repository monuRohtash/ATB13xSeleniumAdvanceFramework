package com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage_imp_pom extends CommonToAllPage {


    WebDriver driver;

    public DashBoardPage_imp_pom(WebDriver driver) {
        this.driver = driver;
    }

    private final By userNameOnDashboard = By.xpath("//h6");

    // Page Actions
    public String loggedInUserName_1() {
        WaitHelpers.visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }

}