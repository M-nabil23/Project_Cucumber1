package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.currenciesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D03_currenciesStepDef {

    currenciesPage currency = new currenciesPage();
    SoftAssert soft = new SoftAssert();

    @When("user select the euro currency from the dropDownList from top left of the home page")
    public void selectingCurrencyFromDDL() {

        Select staticList = new Select(currency.customerCurrency);
        staticList.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");

    }

    @Then("the currency should be changed in the prices of the page")
    public void theCurrencyShouldBeChangedInThePricesOfThePage() {

        for (WebElement e : currency.pricesCurrency) {
            soft.assertTrue(e.getText().contains("€"));
            System.out.println(e.getText());
            soft.assertAll();
        }
    }
}
