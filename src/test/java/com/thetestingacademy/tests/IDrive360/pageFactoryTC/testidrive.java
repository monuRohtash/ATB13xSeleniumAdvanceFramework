package com.thetestingacademy.tests.IDrive360.pageFactoryTC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class testidrive {

    @Test
    public void test1() {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.idrive360.com/enterprise/login");
        driver.getTitle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        user.sendKeys("jekovokida@mailinator.com");

        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        pass.sendKeys("Raghav@123");

        WebElement Btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type=\"submit\"]")));
        Btn.click();


    }


}
