package com.thetestingacademy.tests.OHRM.pageFactoryTC;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageFactory.OHRM.LoginPage_PF_Ohr;

import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.commons.math3.fraction.ProperBigFractionFormat;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.PropertyResourceBundle;

public class TestOHRM_Login_PF extends CommonToAllTest {







    @Owner("Raghav")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void LoginInvalid_Hrm(){

        LoginPage_PF_Ohr loginPage_pf_ohr = new LoginPage_PF_Ohr(DriverManager.getDriver());
        String error_msg = loginPage_pf_ohr.loginInValid_Hrm(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message_hrm"));
    }

}
