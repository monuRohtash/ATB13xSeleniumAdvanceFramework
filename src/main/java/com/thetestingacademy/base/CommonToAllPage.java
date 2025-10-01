package com.thetestingacademy.base;


import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class CommonToAllPage {

    // Common to All page

    public void openVWOUrl() {
        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void openOrangeHRMUrl(){
        getDriver().get(PropertiesReader.readKey("Hrm"));
    }

    public void openIDriveUrl(){
        getDriver().get(PropertiesReader.readKey("idrive_url"));
    }



    public void openKatalonUrl(){
        getDriver().get(PropertiesReader.readKey("katalon_url"));
    }

    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by) {
        by.click();
    }
    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        return by.getText();
    }

}
