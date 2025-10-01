package com.thetestingacademy.tests.IDrive360.pageFactoryTC;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageFactory.IDrive360.LoginPage_PF_IDRIVE;
import com.thetestingacademy.pages.pageFactory.OHRM.LoginPage_PF_Ohr;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIdrive360Login_PF extends CommonToAllTest {




    @Owner("Raghav")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void LoginValid_IDRIVE(){

        LoginPage_PF_IDRIVE loginPagePfIdrive = new LoginPage_PF_IDRIVE(DriverManager.getDriver());
        loginPagePfIdrive.idriveValidLogin(
                PropertiesReader.readKey("emailDrive"),
                PropertiesReader.readKey("PasswordDrive")
        );
    }

}

