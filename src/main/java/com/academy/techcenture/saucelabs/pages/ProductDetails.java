package com.academy.techcenture.saucelabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductDetails {


    private WebDriver driver;
    private WebDriverWait wait;

    public ProductDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @FindBy(xpath = "//div[contains(@class,'inventory_details_name')]")
    private WebElement titleOf1Item;

    @FindBy(xpath = "//div[contains(text(),'Rib snap infant onesie')]")
    private WebElement descriptionOf1Item;

    @FindBy(className = "inventory_details_price")
    private WebElement priceOf1Item;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement addToCartBtnOf1Item;

    @FindBy(id = "remove-sauce-labs-onesie")
    private WebElement removeBtnOf1Item;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIconOf1item;

    @FindBy(id = "back-to-products")
    private WebElement backToProductBtnOf1Item;





    public void verifyFirstItemDetails(){
        titleOf1Item.isDisplayed();
        Assert.assertEquals(titleOf1Item.getText(),"Sauce Labs Onesie", "TITLE OF FIRST ITEM IS NOT DISPLAYED");

        descriptionOf1Item.isDisplayed();
        Assert.assertEquals(descriptionOf1Item.getText(), "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.", "DESCRIPTION OF FIRST ITEM DOES NOT MATCH");

        priceOf1Item.isDisplayed();
        Assert.assertEquals(priceOf1Item.getText(), "$7.99", "PRICE OF FIRST ITEM DOSE NOT MATCH");

        addToCartBtnOf1Item.isDisplayed();
        Assert.assertEquals(addToCartBtnOf1Item.getText(), "ADD TO CART", "ADD TO CART BTN IS NOT DISPLAYED");
        addToCartBtnOf1Item.click();



        removeBtnOf1Item.isDisplayed();
        Assert.assertEquals(removeBtnOf1Item.getText(), "REMOVE", "REMOVE BUTTON DOSE NOT MATCH");

        Assert.assertTrue(cartIconOf1item.isDisplayed(), "ADD TO CART ICON IS NOT THERE");
        cartIconOf1item.click();


    }

}