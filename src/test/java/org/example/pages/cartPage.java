package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartPage extends pageBasePage {



    @FindBy(id = "termsofservice")
    public WebElement termsOfServiceAgreementChecKBox;

    @FindBy(id = "checkout")
    public WebElement checkOutBtn;

    @FindBy(id= "BillingNewAddress_CountryId")
    public WebElement countryDDL;

    @FindBy(id = "BillingNewAddress_City")
    public WebElement cityTextBox;

    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement AddressTextBox;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement zipCodeTextBox;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement phoneTextBox;

    @FindBy(id = "save-billing-address-button")
    public WebElement continueBtn;

    @FindBy(id = "shippingoption_1")
    public WebElement shippingOption;

    @FindBy(className = "shipping-method-next-step-button")
    public WebElement shippingContinueBtn;

    @FindBy(id = "paymentmethod_1")
    public WebElement paymentMethod;

    @FindBy(name = "save")
    public WebElement continueBtnPaymentMethod;



    @FindBy(className = "payment-info-next-step-button")
    public WebElement continueBtnInformationStep;


    @FindBy(className = "confirm-order-next-step-button")
    public WebElement confirmOrderBtnLastStep;


    @FindBy(name = "save")
    public WebElement ContinueBtnPaymentMethod;


    @FindBy(css = " div[class=\"page-title\"] > h1")
    public WebElement thankYouMsg;

    @FindBy(css = "div[class=\"details-link\"] > a")
    public  WebElement orderDetails;


}
