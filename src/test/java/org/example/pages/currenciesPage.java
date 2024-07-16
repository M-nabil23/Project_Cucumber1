package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static org.example.stepDefs.Hooks.driver;

public class currenciesPage {

    public currenciesPage(){

        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "customerCurrency")
    public WebElement customerCurrency;

    @FindBy(className = "actual-price")
    public List<WebElement> pricesCurrency;
}
