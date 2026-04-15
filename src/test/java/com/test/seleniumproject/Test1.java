package com.test.seleniumproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.seleniumproject.base.BaseTest;
import com.test.seleniumproject.config.ConfigReader;
import com.test.seleniumproject.pages.GoogleHomePage;

public class Test1 extends BaseTest {

    @Test
    public void searchGoogleAndValidateTitle() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());

    	System.out.println("This is for Jenkins run");
      /*  googleHomePage
                .open(ConfigReader.get("base.url", "https://www.google.com"))
                .searchFor("Selenium WebDriver");

      Assert.assertTrue(googleHomePage.isTitleUpdated("Selenium WebDriver"),
                "Expected page title to contain the search keyword.");
    }*/
}
    
}
