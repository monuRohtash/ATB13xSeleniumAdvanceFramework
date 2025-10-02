package com.thetestingacademy.tests.OHRM.pageFactoryTC;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageFactory.OHRM.DashBoardPage_PF_Ohr;
import com.thetestingacademy.pages.pageFactory.OHRM.LogOutPage_PF_Ohr;
import com.thetestingacademy.pages.pageFactory.OHRM.LoginPage_PF_Ohr;
import com.thetestingacademy.utils.PropertiesReader;

import com.thetestingacademy.utils.ScreenshotUtils;
import io.qameta.allure.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


@Epic("OrangeHRM Automation")
@Feature("Login with Dashboard & Logout Feature")
public class TestOHRM_Login_PF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestOHRM_Login_PF.class);

    @Owner("Raghav")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Invalid login should show error message")
    @Description("Test verifies that OrangeHRM shows error message for invalid login credentials")
    @Test(description = "Verify invalid login shows error")
    public void LoginInvalid_Hrm() {

        logger.info("Start tha loginPage verifying negativa test case  in  HRM Side ");
        Allure.step("Attempt login with invalid credentials");

        LoginPage_PF_Ohr loginPage_pf_ohr = new LoginPage_PF_Ohr(DriverManager.getDriver());
        String error_msg = loginPage_pf_ohr.loginInValid_Hrm(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        Allure.step("Verify error message is shown");
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message_hrm"));
    }


    @Owner("Raghav")
    @Severity(SeverityLevel.BLOCKER)
    @Story("User should be able to login with valid creds and logout successfully")
    @Description("Test verifies OrangeHRM valid login, dashboard visibility, and logout flow")
    @Test(description = "Verify valid login and logout flow")
    public void testValidLogin() {

        ScreenshotUtils.takeScreenshot("Login Page Opened");
        logger.info("Start tha loginPage verifying positive test case  in  HRM Side ");
        Allure.step("Login with valid credentials");

        LoginPage_PF_Ohr loginPage = new LoginPage_PF_Ohr(DriverManager.getDriver());
        loginPage.loginValid_Hrm(PropertiesReader.readKey("Hrm_username"), PropertiesReader.readKey("Hrm_password"));
        ScreenshotUtils.takeScreenshot("After Login");

        logger.info("Start tha loginPage > Dashboard page verifying positive test case  in  HRM Side ");
        Allure.step("Verify dashboard is visible");
        DashBoardPage_PF_Ohr dashBoardPage_pf_ohr = new DashBoardPage_PF_Ohr(DriverManager.getDriver());
        String dashboard = dashBoardPage_pf_ohr.dislpayDashboard();
        Assert.assertEquals(dashboard, PropertiesReader.readKey("expected_dashboard_ohr"), "Dashboard not visible!");
        ScreenshotUtils.takeScreenshot("Dashboard Visible");
//         Logout
        logger.info("Start tha Logout Page verifying positive test case  in  HRM Side ");
        Allure.step("Logout from dashboard");

        LogOutPage_PF_Ohr logOutPagePfOhr = new LogOutPage_PF_Ohr(DriverManager.getDriver());
        String loinPage = logOutPagePfOhr.logoutUser();
        Allure.step("Verify login page visible after logout");
        Assert.assertEquals(loinPage, "Login", "test pass login to logout user ");
        ScreenshotUtils.takeScreenshot("After Logout");

    }

}

