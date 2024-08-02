package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productDetailsPage extends pageBasePage {


    @FindBy(className = "value")
    public WebElement skuNumber;

}
