package com.academy.techcenture.saucelabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }


    @FindBy(className = "title")
    private WebElement yourOrderHeader;


    @FindBy(className = "cart_quantity")
    private WebElement quantityOf1item;

    @FindBy(id = "checkout")
    private WebElement checkOutBtnOf1Item;




    public void firstItemOverView(){

        yourOrderHeader.isDisplayed();
        Assert.assertEquals(yourOrderHeader.getText(), "YOUR CART");

        quantityOf1item.isDisplayed();
        Assert.assertEquals(quantityOf1item.getText(), "1");

        checkOutBtnOf1Item.isEnabled();
        Assert.assertEquals(checkOutBtnOf1Item.getText(), "CHECKOUT");
        checkOutBtnOf1Item.click();











    }

}
