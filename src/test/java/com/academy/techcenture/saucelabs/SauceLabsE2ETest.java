package com.academy.techcenture.saucelabs;

import com.academy.techcenture.saucelabs.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

    // alisher nawayi
//

public class SauceLabsE2ETest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.saucedemo.com/");

    }

    @Test
    public void sauceLabsE2EETest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        ProductDetails productDetails = new ProductDetails(driver);
        CartPage cartPage = new CartPage(driver);
        CartInfoPage cartInfoPage = new CartInfoPage(driver);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        OverViewPage overViewPage = new OverViewPage(driver);


        loginPage.login();
        productPage.verifyAbout();
        productPage.sortProducts("lowToHigh");
        productPage.verifyFirstAndLastItems();
        productPage.verifyAllItemPrice();
        productPage.verifyTitle();
        productDetails.verifyFirstItemDetails();
        cartPage.firstItemOverView();
        cartInfoPage.cartInformation();
        orderConfirmationPage.checkOutConfirmation();
        overViewPage.verifyLastSteps();


    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}






