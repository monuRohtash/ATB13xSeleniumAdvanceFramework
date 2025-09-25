package com.thetestingacademy.driver;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;

public class DriverManger {

    public static WebDriver driver;


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManger.driver = driver;
    }

    // Initialize WebDriver
    public static void initDriver() {
        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();

        switch (browser) {
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                driver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--Start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;

            default:
                System.out.println("NOt BRowser SUported!");
                throw new IllegalArgumentException("❌ Browser not supported: " + browser);
        }

    }


    // Quit WebDriver
    public static void downDriver() {
        if (getDriver() != null) {
            driver.quit();
            driver = null;
        }
    }

}
