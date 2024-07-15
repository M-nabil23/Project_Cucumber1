package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import  static org.example.stepDefs.Hooks.driver;
public class registerResultPage {

    public registerResultPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "result")
     public WebElement resultText;

    @FindBy(className = "register-continue-button")
     public WebElement continueBtn;

    @FindBy(className = "ico-logout")
    public WebElement logOutBtn;

    }
