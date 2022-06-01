package com.academy.techcenture.saucelabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OrderConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;



    public OrderConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "header_secondary_container")
    private WebElement checkOutOverViewHeader;

    @FindBy(xpath = "(//div[@class= 'summary_info_label'][1])")
    private WebElement paymentInfo;

    @FindBy(xpath = "(//div[@class='summary_value_label'][1])")
    private WebElement confirmationNumber;

    @FindBy(xpath = "(//div[@class= 'summary_info_label'][2])")
    private WebElement shippingInfo;

    @FindBy(xpath = "(//div[@class='summary_value_label'][2])")
    private WebElement shippingInformationTxt;

    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotal;

    @FindBy(className = "summary_tax_label")
    private WebElement tax;

    @FindBy(className = "summary_total_label")
    private WebElement total;

    @FindBy(id = "finish")
    private WebElement finishBtn;




    public void checkOutConfirmation(){
        Assert.assertTrue(checkOutOverViewHeader.isDisplayed());
        Assert.assertTrue(paymentInfo.isDisplayed());
        String[] splitNumber = confirmationNumber.getText().split("#");
        Assert.assertEquals(splitNumber[1], "31337");
        Assert.assertTrue(shippingInfo.isDisplayed());
        Assert.assertEquals(shippingInformationTxt.getText(), "FREE PONY EXPRESS DELIVERY!");
        String[] theItemTotal = itemTotal.getText().split("\\$");
        double parseTheItemTotal = Double.parseDouble(theItemTotal[1]);

        String[] theTax = tax.getText().split("\\$");
        double parseTheTax = Double.parseDouble(theTax[1]);

        String[] theTotal = total.getText().split("\\$");
        double parseTheTotal = Double.parseDouble(theTotal[1]);

        Assert.assertEquals(parseTheItemTotal+parseTheTax, parseTheTotal);
        Assert.assertTrue(finishBtn.isEnabled());
        finishBtn.click();


    }


}
