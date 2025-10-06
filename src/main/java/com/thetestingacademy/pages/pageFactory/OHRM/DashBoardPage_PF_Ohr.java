package com.thetestingacademy.pages.pageFactory.OHRM;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashBoardPage_PF_Ohr extends CommonToAllPage {

    WebDriver driver;

    public DashBoardPage_PF_Ohr(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//h6[text()=\"Dashboard\"]")
    private WebElement dashboardHeader;



//     // ✅ Verify Dashboard is Visible
    public String dislpayDashboard() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getText(dashboardHeader);
    }

}
