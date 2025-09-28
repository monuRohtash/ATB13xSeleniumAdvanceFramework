package com.thetestingacademy.pages.pageFactory;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashBoardPage_PF extends CommonToAllPage {

    WebDriver driver;

    public DashBoardPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    private final By userNameOnDashboard = By.xpath("//h6");

    // This A Page Factory

    @FindBy(xpath = "//h6")
    private WebElement userNameOnDashboard;

    // Page Actions
    public String loggedInUserName() {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        return (WebElement) wait.until(ExpectedConditions.visibilityOfAllElements(userNameOnDashboard));
        WaitHelpers.waitJVM(3000);
        return getText(userNameOnDashboard);
    }

}
