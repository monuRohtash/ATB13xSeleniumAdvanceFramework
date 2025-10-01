package com.thetestingacademy.tests.vwo.DataDrivenTesting;


import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM.LoginPage_imp_pom;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.ScreenshotUtils;
import com.thetestingacademy.utilsExcel.UtilExcel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DataDrivenTesting extends CommonToAllTest {


    private static final Logger logger = LogManager.getLogger(DataDrivenTesting.class);

    @Test(dataProvider = "getData")
    public void test_vwo_login(String email, String password) {

        // Page Class Code (POM Code) - 2 - L

        LoginPage_imp_pom loginPage = new LoginPage_imp_pom(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(email, password);

        // Assertions - 3 - V

        logger.info("Asserting the Invalid credentials");
        ScreenshotUtils.takeScreenshot("data driven login page");
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));


    }

    @DataProvider
    public Object[][] getData() {
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        return UtilExcel.getTestDataFromExcel("sheet1");

    }

}
