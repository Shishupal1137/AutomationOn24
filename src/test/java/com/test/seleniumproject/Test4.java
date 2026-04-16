package com.test.seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Test4 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        Reporter.log("Test started", true);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        Reporter.log("Browser launched", true);

        driver.manage().window().maximize();
    }

    @Test
    public void launchBrowserAndTest() {
        driver.get("https://www.google.com");
        Reporter.log("Opened Google", true);

        driver.findElement(By.name("q")).sendKeys("Selenium TestNG");
        Reporter.log("Search performed", true);

        // Intentionally fail (for testing screenshot)
        // remove this later
        if (true) {
            throw new RuntimeException("Force failure for screenshot");
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result.getName());
            Reporter.log("Screenshot captured for failure", true);
        }

        if (driver != null) {
            driver.quit();
            Reporter.log("Browser closed", true);
        }
    }

    public void takeScreenshot(String testName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File dest = new File("screenshots/" + testName + ".png");
        dest.getParentFile().mkdirs(); // create folder if not exists

        FileUtils.copyFile(src, dest);
    }
}