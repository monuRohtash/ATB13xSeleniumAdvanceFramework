package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {


    @BeforeMethod
    public void setUo() {
        DriverManger.initDriver();
    }

    @AfterMethod
    public void tead() {
        DriverManger.downDriver();
    }


}
