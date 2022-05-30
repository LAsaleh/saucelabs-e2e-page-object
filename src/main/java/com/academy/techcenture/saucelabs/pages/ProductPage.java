package com.academy.techcenture.saucelabs.pages;

import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));

    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuLink;

    @FindBy(xpath = "//a[@class='bm-item menu-item']")
    private List<WebElement> menuItems;

    @FindBy(className = "product_sort_container")
    private WebElement sortComponent;

    public void verifyAbout(){
        menuLink.click();




        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(menuItems.get(1)));

        Assert.assertTrue(menuItems.get(1).isDisplayed());
        menuItems.get(1).click();
        Assert.assertEquals(driver.getTitle(),"Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs");
        driver.navigate().back();
    }

    public void verifyProducts(){
        Assert.assertTrue(menuItems.size() == 6);

    }

    public void sortProducts(String sort) {
        Assert.assertTrue(sortComponent.isDisplayed());
        sortComponent.click();
        Select select = new Select(sortComponent);
        switch (sort) {
            case "lowToHigh":
                select.selectByValue("lohi");
                break;
            case "highToLow":
                select.selectByValue("hilo");
                break;
            case "aToZ":
                select.selectByValue("az");
                break;
            case "zToA":
                select.selectByValue("za");
                break;
        }


    }




    public void verifyFirstAndLastItems () {


    }






}
