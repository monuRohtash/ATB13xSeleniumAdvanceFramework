package com.thetestingacademy.tests.vwo.pageObjectModelTC;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.vwo.Prop_POM.DashBoardPage_Proper_Pom;
import com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM.DashBoardPage_imp_pom;
import com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM.LoginPage_imp_pom;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_03_Prop_Improved_POM  extends CommonToAllTest {

    //  D
    // L
    // V

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_03_Prop_Improved_POM.class);


    @Owner("PRAMOD")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {

        logger.info("Starting the testLoginPositiveVWO");

        // Page Class Code (POM Code) - 2 - L
        LoginPage_imp_pom loginPage = new LoginPage_imp_pom(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        // Assertions - 3 - V

        logger.info("Asserting the invalid credentials");

        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));


    }

    @Owner("PRAMOD")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        logger.info("Starting the Testcases Page Object Model");


        // Page Class Code (POM Code) - 2 - L
        LoginPage_imp_pom loginPage_VWO = new LoginPage_imp_pom(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));

        DashBoardPage_imp_pom dashBoardPage_imp_pom  = new DashBoardPage_imp_pom(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage_imp_pom.loggedInUserName_1();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        logger.info("Done the Test cases   -> testLoginPositiveVWO" );
        Assert.assertEquals(usernameLoggedIn, PropertiesReader.readKey("expected_username"));


    }
}


