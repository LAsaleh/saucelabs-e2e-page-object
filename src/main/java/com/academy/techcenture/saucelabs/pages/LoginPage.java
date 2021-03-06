package com.academy.techcenture.saucelabs.pages;

import com.academy.techcenture.saucelabs.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.netty.NettyClient;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoginPage {
  //  i need to store the web elements.
    // i need to present methods which they will represent actions
    // i need to do assertions and validation


    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(className = "login_logo")
    private WebElement loginLogo;

    @FindBy(className = "bot_column")
    private WebElement botImg;

    public void login(){
        Assert.assertTrue(loginLogo.isDisplayed());
        Assert.assertTrue(botImg.isDisplayed());

        userNameInput.sendKeys(ConfigReader.getProperty("userName"));
        passwordInput.sendKeys(ConfigReader.getProperty("password"));

        Assert.assertTrue(loginBtn.isEnabled());
        loginBtn.click();

        new SimpleDateFormat("99/99/9999").format(Calendar.getInstance().getTime());
    }
}
