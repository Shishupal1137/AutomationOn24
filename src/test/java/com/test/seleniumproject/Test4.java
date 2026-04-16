
package com.test.seleniumproject;
import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Test4 {

    @Test
    public void launchBrowserAndTest() {

        Reporter.log("Test started", true);

        // Launch browser
        WebDriver driver = new ChromeDriver();
        Reporter.log("Browser launched successfully", true);

        // Open URL
        driver.get("https://www.google.com");
        Reporter.log("Navigated to Google", true);

        // Maximize window
        driver.manage().window().maximize();
        Reporter.log("Browser maximized", true);

        // Perform operation - search something
        driver.findElement(By.name("q")).sendKeys("Selenium TestNG");
        Reporter.log("Entered text in search box", true);

        // Small wait (not best practice, but ok for demo)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close browser
        driver.quit();
        Reporter.log("Browser closed", true);

        Reporter.log("Test completed", true);
    }
}