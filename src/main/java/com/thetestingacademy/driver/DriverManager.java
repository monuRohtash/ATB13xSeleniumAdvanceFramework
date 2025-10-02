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
                // chromeOptions.addArguments("--start-maximized");
//                if (isHeadless) {
//                    chromeOptions.addArguments("--headless=new");
//                }
//
//                if (isIncognito){
//                    chromeOptions.addArguments("inprivate");
//                }
                    
                
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

