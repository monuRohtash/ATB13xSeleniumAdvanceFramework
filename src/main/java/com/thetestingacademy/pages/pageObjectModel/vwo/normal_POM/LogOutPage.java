package com.thetestingacademy.pages.pageObjectModel.vwo.normal_POM;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage {

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;


    private final By userLogOut_drop = By.xpath("//button[@aria-label='Open user menu']");
    private final By logout_btn = By.xpath("//*[text()='Logout']");
    private final By VerifyLogin_Page_Text = By.xpath("//*[text()=\"Sign in to VWO platform\"]");


    public String logoutUser() {
        WaitHelpers.waitJVM(2000);
        driver.navigate().to("https://app.vwo.com/#/login");
        driver.findElement(userLogOut_drop).click();

        WebElement logoutBtn = driver.findElement(logout_btn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutBtn);


        return driver.findElement(VerifyLogin_Page_Text).getText();
    }


}
