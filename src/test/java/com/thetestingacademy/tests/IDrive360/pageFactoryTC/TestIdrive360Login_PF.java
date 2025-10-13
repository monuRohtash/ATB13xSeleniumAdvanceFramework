package com.thetestingacademy.tests.IDrive360.pageFactoryTC;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageFactory.IDrive360.DashBoardPage_PF_IDRIVE;
import com.thetestingacademy.pages.pageFactory.IDrive360.LogOutPage_PF_IDRIVE;
import com.thetestingacademy.pages.pageFactory.IDrive360.LoginPage_PF_IDRIVE;

import com.thetestingacademy.pages.pageFactory.IDrive360.PaymentPage_PF_IDRIVE;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManager.driver;


public class TestIdrive360Login_PF extends CommonToAllTest {

    private static final Logger log = LogManager.getLogger(TestIdrive360Login_PF.class);


    @Owner("Raghav")
    @Description("Verify that with invalid email, pass, error message is shown on the IDrive")
    @Test
    public void LoginINvalid_IDRIVE() {

        log.info("Starting invalid login test for IDrive...");
        LoginPage_PF_IDRIVE loginPagePfIdrive = new LoginPage_PF_IDRIVE(DriverManager.getDriver());

        log.debug("Reading invalid credentials from properties...");
        String invalid_Cred = loginPagePfIdrive.idriveINvalidLogin(
                PropertiesReader.readKey("invalid_eamil"),
                PropertiesReader.readKey("invalid_pword"));

        log.info("Verifying error message for invalid credentials...");
        Assert.assertEquals(invalid_Cred, PropertiesReader.readKey("error_msg_Drive"),
                "Error message did not match expected value");

        log.info("Invalid login test completed successfully.");
    }


    @Owner("Raghav")
    @Description("Verify that with Valid email & password, user is navigated to Dashboard")
    @Test
    public void LoginValid_IDRIVE() {

        log.info("Starting valid login test for IDrive...");

        LoginPage_PF_IDRIVE loginPagePfIdrive = new LoginPage_PF_IDRIVE(DriverManager.getDriver());
        loginPagePfIdrive.idriveValidLogin(
                PropertiesReader.readKey("emailDrive"),
                PropertiesReader.readKey("PasswordDrive")
        );
        log.info("Valid login test completed successfully.");


        DashBoardPage_PF_IDRIVE dashBoardPage_pf_idrive = new DashBoardPage_PF_IDRIVE(DriverManager.getDriver());
        log.info("Checking if Dashboard is displayed after login...");
        // Verify dashboard loaded - using a dashboard element
        boolean isDashboardVisible = dashBoardPage_pf_idrive.isDashboardDisplayed();
        Assert.assertTrue(isDashboardVisible, " Dashboard was not displayed after login.");
        log.info("Dashboard verified successfully.");

        log.info("payment form started.............");

        // ✅ Step 1: Open Payment Page
        PaymentPage_PF_IDRIVE paymentPage_pf_idrive = new PaymentPage_PF_IDRIVE(DriverManager.getDriver());

        // ✅ Step 2: Fill Card Details (inside iframe)
        paymentPage_pf_idrive.fillCardDetails("4000000000009995", "12/28", "123");

        // ✅ Step 3: Fill Billing Address, Country, State, Postal
        paymentPage_pf_idrive.fillPaymentForm("123 Main Street", "India", "California", "90001");

        // ✅ Step 4: Wait and validate (you can add success message verification)
        WaitHelpers.waitJVM(3000);
        log.info(" Payment form filled successfully ");

        // user is logged in
        LogOutPage_PF_IDRIVE logoutPage = new LogOutPage_PF_IDRIVE(DriverManager.getDriver());
//         logoutPage.performLogout();
        String LoggedOut = logoutPage.logoutUserDrive();
        Assert.assertEquals(LoggedOut,"Sign in to IDrive 360", "");


        log.info("Logout successful!.............");



    }

}

