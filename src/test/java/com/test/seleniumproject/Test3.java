package com.test.seleniumproject;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test3 {
    
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Initialize the driver before every test method
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void launchFlipkart() {
        // The actual test logic
        driver.get("https://www.flipkart.com");
        
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Reporter.log("Test started");
        Reporter.log("Test Ended");
     
        
        // Basic TestNG validation
        assert title.contains("Online Shopping");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test is complete
        if (driver != null) {
            driver.quit();
        }
    }
}