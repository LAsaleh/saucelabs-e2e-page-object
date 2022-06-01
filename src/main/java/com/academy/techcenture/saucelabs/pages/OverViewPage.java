package com.academy.techcenture.saucelabs.pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OverViewPage {


    private WebDriver driver;
    private WebDriverWait wait;


    public OverViewPage(WebDriver driver){
        this.driver = driver;
        this. wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);

    }


    @FindBy(className = "complete-header")
    private WebElement thanks;

    @FindBy(className = "complete-text")
    private WebElement orderCompletedTxt;

    @FindBy(id = "back-to-products")
    private WebElement backHomeBtn;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutLink;


    public void verifyLastSteps() throws InterruptedException {
        Assert.assertTrue(thanks.isDisplayed());
        Assert.assertEquals(orderCompletedTxt.getText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        Assert.assertTrue(backHomeBtn.isEnabled());
        backHomeBtn.click();
        Assert.assertTrue(menuBtn.isDisplayed());
        menuBtn.click();
        logOutLink.click();

        Thread.sleep(3000);
        driver.close();

    }



}
