package com.test.seleniumproject.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.test.seleniumproject.core.DriverFactory;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}
