package com.test.seleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

    @Test
    public void openGoogle() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        System.out.println("Title: " + driver.getTitle());
        
        System.out.println("PR demo working");
        
        

        System.out.println("Main branch change");

        System.out.println("Feature branch change");
        


        driver.quit();
    }
}
//i take pull of that code
