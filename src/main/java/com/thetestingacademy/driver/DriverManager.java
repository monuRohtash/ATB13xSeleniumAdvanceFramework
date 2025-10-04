package com.thetestingacademy.driver;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver driver;


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    // Initialize WebDriver
    public static void initDriver() {
        String browser = PropertiesReader.readKey("browser").toLowerCase();
        String headlessProp = PropertiesReader.readKey("headless"); // add in properties
        String incognitoProp = PropertiesReader.readKey("incognito"); // config.properties


        boolean isHeadless = headlessProp != null && headlessProp.equalsIgnoreCase("true");
        boolean isIncognito = incognitoProp != null && incognitoProp.equalsIgnoreCase("true");


        switch (browser) {
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                if (isHeadless) {
                    edgeOptions.addArguments("--headless=new");
                }
                if (isIncognito) {
                    edgeOptions.addArguments("--inprivate");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--Start-maximized");
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless=new");
                }
                if (isIncognito){
                    firefoxOptions.addArguments("-private");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "chrome":
                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--start-maximized");
//                if (isHeadless) {
//                    chromeOptions.addArguments("--headless=new");
//                }
//
//                if (isIncognito){
//                    chromeOptions.addArguments("inprivate");
//                }
                     // Jenkins/Linux friendly settings
//        options.addArguments("--headless"); // GUI नहीं खुलेगा
//        options.addArguments("--disable-gpu"); // headless के साथ compatibility
        options.addArguments("--window-size=1920,1080"); // window size set
        options.addArguments("--no-sandbox"); // Linux में permissions issue रोकने के लिए
        options.addArguments("--disable-dev-shm-usage"); // Linux Docker/Jenkins memory issue रोकने के लिए
        options.addArguments("--start-maximized");
//
//        // हर session के लिए unique user data directory
        options.addArguments("--user-data-dir=/tmp/unique-chrome-profile-" + System.currentTimeMillis());
//
//        // Chrome binary path (Linux में जरूरी हो सकता है)
        options.setBinary("/usr/bin/google-chrome");
                
                driver = new ChromeDriver(options);

                break;
            default:
                System.out.println(" ❌ Browser not supported: " + browser);
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

