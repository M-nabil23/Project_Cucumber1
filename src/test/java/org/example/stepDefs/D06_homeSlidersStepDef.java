package org.example.stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class D06_homeSlidersStepDef  {
    WebDriverWait wait;
    homePage home = new homePage();
    SoftAssert soft = new SoftAssert();
    //first slider scenario
    @Given("the user clicks on the first slider in the home page")
    public void theUserClicksOnTheFirstSliderInTheHomepage() {
        wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(home.sliders("1"),"style","display: block;"));
        home.sliders("1").click();

    }

    @Then("the user should be redirected to a new page according to the first slider")
    public void theUserShouldBeRedirectedToANewPageAccordingToTheFirstSlider()
    {

        String actualUrl = driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        soft.assertTrue(actualUrl.contains(expectedUrl));
        soft.assertAll();
    }




    //second slider scenario
    @Given("the user clicks on the second slider in the home page")
    public void theUserClicksOnTheSecondSliderInTheHomePage() throws InterruptedException {
        wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(8));
        wait.until(ExpectedConditions.attributeContains(home.sliders("2"),"style","display: block;"));
        home.sliders("2").click();

    }

    @Then("the user should be redirected to a new page according to the second slider")
    public void theUserShouldBeRedirectedToANewPageAccordingToTheSecondSlider()
    {
        String actualUrl = driver.getCurrentUrl();
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        String expectedUrl = "https://demo.nopcommerce.com/iphone-6";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        soft.assertTrue(actualUrl.contains(expectedUrl));
        soft.assertAll();
    }
}
