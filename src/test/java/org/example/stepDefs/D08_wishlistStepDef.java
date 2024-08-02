package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.example.stepDefs.Hooks.driver;
import org.example.pages.homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_wishlistStepDef {


    homePage home = new homePage();
    SoftAssert soft = new SoftAssert();


    //SharedSteps
    @When("the user clicks on the wishList button of a product")
    public void theUserClicksOnTheWishListButtonOfAProduct()
    {
        //Click on the wishList of a product
        home.productWishListButton.click();

    }

    // First scenario
    @Then("adding to the wishList should display an alert and be successful")
    public void addingToTheWishListShouldDisplayAnAlertAndBeSuccessful()
    {
            //What we do here?
//        - go to https://demo.nopcommerce.com/
//        - you will find 4 products in the middle of the home page [Build your own computer, Apple MacBook Pro 13-inch, HTC
//        One M8 Android L 5.0 Lollipop, $25 Virtual Gift Card]
//        - if you click on wishlist button ❤️ on this product "HTC One M8 Android L 5.0 Lollipop"
//        you will see success message "The product has been added to your wishlist" with green background color
//        - Use Soft assertion to verify the following
//       part 1 = success message is displayed
//       part 2 = background color is green
//        Note: if you choose to verify Hex value then you will have to convert the color from RGBA to Hex

        //background-color #4bb07a
        // part 1
        String actualMsgText =  home.alert.getText();
        System.out.println(actualMsgText);
        soft.assertTrue(actualMsgText.contains("The product has been added to your wishlist"));

        // part 2
        //background-color #4bb07a
        WebElement alertLocator =  home.alertBackGround;

        // it's not necessary, but I had to make sure the alert is exists
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.attributeContains(alertLocator,"style","display: block;"));


        String actualBackGroundColor = alertLocator.getCssValue("background-color");
        System.out.println("This is the background Color value: " + actualBackGroundColor);

        String actualBackGroundColorInHex = Color.fromString(actualBackGroundColor).asHex();
        soft.assertTrue(actualBackGroundColorInHex.contains("#4bb07a"));

        System.out.println(actualBackGroundColorInHex);

        soft.assertAll();
    }

    // Second Scenario


    @And("Wait until the alert disappear Then click on the wishlist tab at the header")
    public void waitUntilTheAlertDisappearThenClickOnTheWishlistTabAtTheHeader()
    {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class=\"bar-notification success\"]")));

        home.wishListTab.click();

    }

    @Then("the wishList counter should be changed after adding the product to it")
    public void theWishListCounterShouldBeChangedAfterAddingTheProductToIt()
    {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/wishlist"));

        String wishListValue =  driver.findElement(By.cssSelector("td[class=\"quantity\"] > input")).getAttribute("value");
        System.out.println(wishListValue);

        soft.assertNotEquals(wishListValue,"0");
        soft.assertEquals(wishListValue,"1");

        soft.assertAll();
    }
}
