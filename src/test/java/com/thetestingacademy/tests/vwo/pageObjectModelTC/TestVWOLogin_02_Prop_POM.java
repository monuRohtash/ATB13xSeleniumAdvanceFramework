package com.thetestingacademy.tests.vwo.pageObjectModelTC;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManger;
import com.thetestingacademy.pages.pageObjectModel.vwo.Prop_POM.DashBoardPage_Proper_Pom;
import com.thetestingacademy.pages.pageObjectModel.vwo.Prop_POM.LoginPage_Proper_Pom;
import com.thetestingacademy.pages.pageObjectModel.vwo.normal_POM.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.normal_POM.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_Prop_POM extends CommonToAllTest {



    //  D
    // L
    // V

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_02_Prop_POM.class);


    @Owner("Rohtash")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {

        logger.info("Starting the Testcases Page Object Model");


        // Page Class Code (POM Code) - 2 - L
        LoginPage_Proper_Pom loginPage = new LoginPage_Proper_Pom(DriverManger.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        // Assertions - 3 - V

        logger.info("Asserting the invalid credentials");

        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));



    }

    @Owner("Rohtash")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test(dependsOnMethods = "TestVWOLogin_02_Prop_POM")
    public void testLoginPositiveVWO() {

        logger.info("Starting the Testcases Page Object Model");


        // Page Class Code (POM Code) - 2 - L
        LoginPage_Proper_Pom loginPage_VWO = new LoginPage_Proper_Pom(DriverManger.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage_Proper_Pom dashBoardPage  = new DashBoardPage_Proper_Pom(DriverManger.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        logger.info("Done the Test cases");
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));



    }


}
