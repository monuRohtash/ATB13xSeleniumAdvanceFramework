package com.thetestingacademy.tests.vwo.pageFactoryTC;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.listeners.ScreenshotListener;
import com.thetestingacademy.pages.pageFactory.DashBoardPage_PF;
import com.thetestingacademy.pages.pageFactory.LogOutPage_PF;
import com.thetestingacademy.pages.pageFactory.LoginPage_PF;
import com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.ScreenshotUtils;
import com.thetestingacademy.utils.WaitHelpers;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_PF extends CommonToAllTest {


    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);

    @Owner("Raghav")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void loginToVWOLoginInvalidCreds() {

        logger.info("Starting the Testcases Page Factory = testLoginNegativeVWO_PF");

        LoginPage_PF loginPage_PF1 = new LoginPage_PF(DriverManager.getDriver());
        String error_msg = loginPage_PF1.loginToVWOLoginInvalidCreds_PF(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));


        logger.info("Finished the Testcases Page Factory");

        ScreenshotUtils.takeScreenshot("Page Factory test 1");

        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }


    @Owner("Raghav")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void loginToVWOLoginValidCreds() {

        logger.info("Starting the Testcases Page factory = loginToVWOLoginValidCreds");

        // Page Class Code (POM Code) - 2 - L
        LoginPage_PF loginPage_PF2 = new LoginPage_PF(DriverManager.getDriver());
        loginPage_PF2.loginToVWOLoginValidCreds_PF(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));

        DashBoardPage_PF dashBoardPage = new DashBoardPage_PF(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        logger.info("Page Factory Dashboard Page");
        Assert.assertEquals(usernameLoggedIn, PropertiesReader.readKey("expected_username"));
        ScreenshotUtils.takeScreenshot("Page Factory test 2");

        // Logout page test
        LogOutPage_PF logOutPage_pf = new LogOutPage_PF(DriverManager.getDriver());
        String usernameLoggedOut = logOutPage_pf.logoutUser();
        logger.info("Page Factory Logout user ");
        Assert.assertEquals(usernameLoggedOut,PropertiesReader.readKey("LogOutPageMSg") );
        ScreenshotUtils.takeScreenshot("Page Factory LogOutPageMSg 3");


    }

}
