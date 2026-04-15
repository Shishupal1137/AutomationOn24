package com.test.seleniumproject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.seleniumproject.utils.WaitUtils;

public class GoogleHomePage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    @FindBy(name = "q")
    private WebElement searchBox;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleHomePage open(String url) {
        driver.get(url);
        return this;
    }

    public GoogleHomePage searchFor(String searchText) {
        waitUtils.waitForVisibility(searchBox).sendKeys(searchText + Keys.ENTER);
        return this;
    }

    public boolean isTitleUpdated(String expectedText) {
        return waitUtils.waitForTitleContains(expectedText);
    }
}
