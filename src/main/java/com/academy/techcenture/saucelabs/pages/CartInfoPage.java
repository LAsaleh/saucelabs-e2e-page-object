package com.academy.techcenture.saucelabs.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class CartInfoPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Faker faker;


    public CartInfoPage(WebDriver driver) {
        this.driver = driver;
        this.faker = new Faker();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @FindBy(id = "first-name")
    private WebElement inputFirstName;

    @FindBy(id = "last-name")
    private WebElement inputLastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;


    @FindBy(id = "continue")
    private WebElement continueBtn;

    public void cartInformation(){

      Assert.assertTrue(inputFirstName.isDisplayed(), "FIRST NAME INPUT IS NOT THERE");
        inputFirstName.sendKeys(faker.name().firstName());

      Assert.assertTrue(inputLastName.isDisplayed(), "LAST NAME INPUT IS NOT THERE");
      inputLastName.sendKeys(faker.name().lastName());

      Assert.assertTrue(postalCode.isDisplayed(), "POSTAL CODE IS THERE");
      postalCode.sendKeys(faker.address().zipCode().substring(0,5));

      Assert.assertTrue(continueBtn.isEnabled(), "CONTINUE BUTTON IS ENABLED");
      continueBtn.click();




    }

}
