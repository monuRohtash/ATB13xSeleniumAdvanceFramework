package com.thetestingacademy.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.thetestingacademy.driver.DriverManger.driver;
import static com.thetestingacademy.driver.DriverManger.getDriver;

public class ScreenshotUtils {

    public static void takeScreenshot(String testName) {

        WebDriver driver = getDriver();

        // Get browser name from driver class
        String browserName = driver.getClass().getSimpleName().toLowerCase();
        if (browserName.contains("chrome")) browserName = "chrome";
        else if (browserName.contains("firefox")) browserName = "firefox";
        else if (browserName.contains("edge")) browserName = "edge";
        else browserName = "unknown";


        // Generate timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());


        try {

            // Create folder if not exists
            String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
            Files.createDirectories(new File(screenshotDir).toPath());

            // Screenshot path
            String screenshotPath = screenshotDir + testName + "_" + browserName + "_" + timestamp + ".png";

            // Take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(srcFile.toPath(), new File(screenshotPath).toPath());

            System.out.println("📸 Screenshot saved: " + screenshotPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
}

}
