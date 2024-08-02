package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class contactUsPage {

    @FindBy(id = "FullName")
    public WebElement contactUsName;

    @FindBy(id = "Email")
    public WebElement contactUsEmail;

    @FindBy(id = "Enquiry")
    public WebElement contactUsEnquiry;

    @FindBy(id="FullName-error")
    public WebElement contactUsNameError;

    @FindBy(id = "Email-error")
    public WebElement contactUsEmailError;

    @FindBy(id = "Enquiry-error")
    public WebElement contactUsInquiryError;

    @FindBy(className = "result")
    public WebElement contactUsSuccess;

    @FindBy(css = "ul[class=\"list\"] > li > a")
    public WebElement contactUsFooterBtn;


    @FindBy(name = "send-email")
    public WebElement submitBtn;
}
