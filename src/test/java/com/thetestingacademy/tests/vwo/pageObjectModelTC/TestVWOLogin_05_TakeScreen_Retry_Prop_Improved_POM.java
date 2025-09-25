package com.thetestingacademy.tests.vwo.pageObjectModelTC;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.listeners.ScreenshotListener;
import com.thetestingacademy.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManger.getDriver;


@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_05_TakeScreen_Retry_Prop_Improved_POM extends CommonToAllTest {


    private static final Logger logger = LogManager.getLogger(TestVWOLogin_05_TakeScreen_Retry_Prop_Improved_POM.class);

    @Owner("Raghav")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Allure.addAttachment("Log output", "text/plain", "This is some log text");
        ScreenshotUtils.takeScreenshot("testPass_1");
        Assert.assertTrue(false);
    }

    @Owner("Raghav")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model - test pass");
        Allure.addAttachment("Log output", "text/plain", "This is some log text");
        ScreenshotUtils.takeScreenshot("testPass_2");
        Assert.assertTrue(true);
    }

}
