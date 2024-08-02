package org.example.stepDefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.example.pages.productDetailsPage;
import org.example.pages.searchDetailsPage;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.Hooks.driver;
public class D04_searchStepDef {

    homePage home = new homePage();
    searchDetailsPage searchDetails = new searchDetailsPage();
    productDetailsPage productDetails = new productDetailsPage();
    SoftAssert soft = new SoftAssert();

    @When("the user enter the {string} in the search textField")
    public void theUserEnterTheInTheSearchTextField(String arg0) throws InterruptedException {
        home.searchTextField.sendKeys(arg0);
        Thread.sleep(3000);
    }

    @And("the user clicks on the search Button")
    public void theUserClicksOnTheSearchButton() {
        home.SearchButton.click();
    }

    @Then("the search result should display the right data {string}")
    public void theSearchResultShouldDisplayTheRightData(String arg0){

        String url = driver.getCurrentUrl();
        soft.assertTrue(url.contains("https://demo.nopcommerce.com/search?q="));

        int countOfProducts = searchDetails.numberOfItemsInTheSearchResult.size();
        System.out.println(countOfProducts);

        //hint: you can assert on a whole word not a part of it, like book it will fail with Macbook
        for (WebElement e : searchDetails.productName) {
            System.out.println(e);
            soft.assertTrue(e.getText().toLowerCase().contains(arg0));
            System.out.println(e);
            soft.assertAll();
        }


    }

    @When("the user enter the {string} in the search textField bar")
    public void theUserEnterTheInTheSearchTextFieldBar(String arg0)
    {
        home.searchTextField.sendKeys(arg0);
    }

    @And("the user  clicks on the product in search result")
    public void theUserClicksOnTheProductInSearchResult()
    {
        searchDetails.productPic.click();
    }

    @Then("the user should be able to see the product details {string}")
    public void theUserShouldBeAbleToSeeTheProductDetails(String arg0) {

        soft.assertTrue(productDetails.skuNumber.getText().contains(arg0));
        soft.assertAll();
    }
}

