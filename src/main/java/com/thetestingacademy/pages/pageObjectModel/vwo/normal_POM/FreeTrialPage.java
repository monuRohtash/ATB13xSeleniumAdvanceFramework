package com.thetestingacademy.pages.pageObjectModel.vwo.normal_POM;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeTrialPage {

    WebDriver driver;

    public FreeTrialPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By email_input = By.id("page-v1-step1-email");
    private final By checkBox = By.id("page-free-trial-step1-cu-gdpr-consent-checkbox");
    private final By submitButton = By.xpath("//button[text()=\"Create a Free Trial Account\"]");
    private final By error_msg_xpath = By.xpath("//div[contains(@class,\"invalid-reason\")]");




    public String enterDetailsInvalid(String email){
        driver.get("https://vwo.com/free-trial/");
        driver.findElement(email_input).sendKeys(email);
        driver.findElement(checkBox).click();
        driver.findElement(submitButton).click();


        return driver.findElement(error_msg_xpath).getText();




    }


//
    public String enterDetailsValid(String email){
        driver.get("https://vwo.com/free-trial/");
        driver.findElement(email_input).sendKeys(email);

        driver.findElement(checkBox).click();
        driver.findElement(submitButton).click();

        // Wait - Thread sleep
        WaitHelpers.waitJVM(5000);
        return email;
    }










}

