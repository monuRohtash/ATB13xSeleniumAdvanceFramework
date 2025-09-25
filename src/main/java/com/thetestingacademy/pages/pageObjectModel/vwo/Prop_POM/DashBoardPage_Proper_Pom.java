package com.thetestingacademy.pages.pageObjectModel.vwo.Prop_POM;

import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage_Proper_Pom{



    WebDriver driver;

    public DashBoardPage_Proper_Pom(WebDriver driver) {
        this.driver = driver;
    }

    private final By userNameOnDashboard = By.xpath("//h6");


    public String loggedInUserName(){
        WaitHelpers.waitJVM(10000);
        driver.get(PropertiesReader.readKey("Dash_url"));
        return driver.findElement(userNameOnDashboard).getText();
    }


}
