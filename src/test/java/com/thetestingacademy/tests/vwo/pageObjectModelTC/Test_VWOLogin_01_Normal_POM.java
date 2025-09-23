package com.thetestingacademy.tests.vwo.pageObjectModelTC;

import com.thetestingacademy.pages.pageObjectModel.vwo.normal_POM.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.normal_POM.FreeTrialPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.normal_POM.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test_VWOLogin_01_Normal_POM {

    WebDriver driver;

    //  D
    // L
    // V


    @Owner("Rohtash")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {

        // Driver Manager Code - 1 - D
         driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Page Class Code (POM Code) - 2 - L
        //Login page
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCreds("hebiva4776@amcret.com", "Wrong");

        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

        //Free trial page
        FreeTrialPage freeTrialPage = new FreeTrialPage(driver);
        String freeTrial_error_msg = freeTrialPage.enterDetailsInvalid("");

        // Expect validation: "Blank Email" message should appear
        assertThat(freeTrial_error_msg).isNotBlank().isNotBlank().isNotEmpty();
        Assert.assertEquals(freeTrial_error_msg, "A value for this field is required.");

        System.out.println("freeTrialPage" + freeTrial_error_msg);
        driver.quit();
    }

    @Owner("Rohtash")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test(dependsOnMethods = "")
    public void testLoginPositiveVWO() {

        // Driver Manager Code - 1
        driver = new ChromeDriver();
        driver.manage().window().minimize();

//         Page Class Code (POM Code) - 2 - L
        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginValidCreds("hebiva4776@amcret.com" , "Test@4321");

        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Amcret");






        driver.quit();


    }

}