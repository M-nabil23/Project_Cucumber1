package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.currenciesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.Hooks.driver;

import java.util.List;

public class currencies {

    currenciesPage currency = new currenciesPage();
    SoftAssert soft = new SoftAssert();

    @Given("user select the euro currency from the dropDownList from top left of the home page")
    public void selectingCurrencyFromDDL() {

        Select staticList = new Select(currency.customerCurrency);
        staticList.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");

    }

    @Then("the currency should be changed in the prices of the page")
    public void theCurrencyShouldBeChangedInThePricesOfThePage() {
       // span[class$="actual-price"]
//        String currencySign = driver.findElements(By.cssSelector("div[class=\"product-grid home-page-product-grid\"] div[class=\"item-grid\"] div[class=item-box]")).get(1).getText();
//        soft.assertTrue(currencySign.contains("€"));
//        System.out.println(currencySign);


        // Get element with tag name 'div'
        WebElement element = driver.findElement(By.tagName("span"));

        // Get all the elements available with tag name 'p'
        List<WebElement> elements = element.findElements(By.className("actual-price"));
        for (WebElement e : elements) {
            System.out.println(e.getText());
            soft.assertTrue(e.getText().contains("€"));
            System.out.println(e.getText());
            System.out.println(e);

            soft.assertAll();
        }
    }
}
