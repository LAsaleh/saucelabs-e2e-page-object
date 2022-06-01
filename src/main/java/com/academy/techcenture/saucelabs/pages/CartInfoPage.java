package com.academy.techcenture.saucelabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class CartInfoPage extends JavaFaker{

    private WebDriver driver;
    private WebDriverWait wait;

    public CartInfoPage(WebDriver driver) {
        this.driver = driver;
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
       String firstName = randomFirstName().toLowerCase();
       String lastName = randomLastName().toUpperCase();
       String zipCode = randomPostalCode();


      Assert.assertTrue(inputFirstName.isDisplayed(), "FIRST NAME INPUT IS NOT THERE");
        inputFirstName.sendKeys(firstName);

      Assert.assertTrue(inputLastName.isDisplayed(), "LAST NAME INPUT IS NOT THERE");
      inputLastName.sendKeys(lastName);


      Assert.assertTrue(postalCode.isDisplayed(), "POSTAL CODE IS THERE");
      postalCode.sendKeys(zipCode);


      Assert.assertTrue(continueBtn.isEnabled(), "CONTINUE BUTTON IS ENABLED");
      continueBtn.click();




    }

}
