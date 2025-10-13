package com.thetestingacademy.base;


import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class CommonToAllPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public CommonToAllPage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // default wait
    }

    // ================== Open URLs ==================
    public void openVWOUrl() {
        driver.get(PropertiesReader.readKey("url"));
    }

    public void openOrangeHRMUrl() {
        driver.get(PropertiesReader.readKey("Hrm"));
    }

    public void openIDriveUrl() {
        driver.get(PropertiesReader.readKey("idrive_url"));
    }

    public void openKatalonUrl() {
        driver.get(PropertiesReader.readKey("katalon_url"));
    }

    // ================== Click ==================
    public void clickElement(By by) {
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(by));
        ele.click();
    }

    public void clickElement(WebElement element) {
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
        ele.click();
    }

    // ================== Enter Input ==================
    public void enterInput(By by, String key) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        ele.clear();
        ele.sendKeys(key);
    }

    public void enterInput(WebElement element, String key) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
        ele.clear();
        ele.sendKeys(key);
    }

    // ================== Get Text ==================
    public String getText(By by) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return ele.getText();
    }

    public String getText(WebElement element) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
        return ele.getText();
    }

    // ================== Is Displayed ==================
    public boolean isDisplayed(WebElement element) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
        return ele.isDisplayed();
    }

    public boolean isDisplayed(By by) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return ele.isDisplayed();
    }


}
