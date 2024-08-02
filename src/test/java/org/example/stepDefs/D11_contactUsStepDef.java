package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.contactUsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Objects;

import static org.example.stepDefs.Hooks.driver;
public class D11_contactUsStepDef {

    contactUsPage contactUs = new contactUsPage();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    SoftAssert soft = new SoftAssert();
    @Given("The user go to the Contact us page")
    public void TheUserGoToTheContactUsPage()
    {


       try {

           // Create an instance of WebDriverWait
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         // Wait until the "Contact Us" link in the footer is visible
          WebElement contactUsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                  By.xpath("//div[@class='footer']//a[contains(text(),'Contact us')]")));


            // Click the "Contact Us" link
            contactUsLink.click();

           // Print confirmation
           System.out.println("Successfully clicked on the 'Contact Us' link.");
       } catch (Exception e) {
           // Print any errors that occur
            System.err.println("An error occurred: " + e.getMessage());
       }
    }

    @When("The user enter his name")
    public void theUserEnterHisName() {

        // Create an instance of WebDriverWait


        // Wait until the "Contact Us" link in the footer is visible
        WebElement contactName = wait.until(ExpectedConditions.visibilityOfElementLocated(
               By.id("FullName")));

        Faker fake = new Faker();
      String  Name =  fake.name().fullName();
        contactName.sendKeys(Name);
    }

    @And("The user enter his email")
    public void theUserEnterHisEmail() {

        WebElement contactEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("Email")));

        Faker fake = new Faker();
      String fakeEmail =  fake.internet().emailAddress();
        contactEmail.sendKeys(fakeEmail);
    }

    @And("The user enter his Enquiry")
    public void theUserEnterHisEnquiry() {
        WebElement contactInquiry = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("Enquiry")));
        Faker fake = new Faker();
        String fakeEnquiry = fake.internet().slug();
        contactInquiry.sendKeys(fakeEnquiry);
    }

    @Then("The user should be able to send the msg Successfully")
    public void theUserShouldBeAbleToSendTheMsgSuccessfully() {

        // Wait for the success message to be visible on the page
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("send-email")));

        // Click the submit button
        submitBtn.click();

        // Wait for the success message to be visible on the page
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[class=\"page-body\"] > div[class=\"result\"]")));

        // Verify that the success message contains the expected text
        soft.assertTrue(successMsg.getText().contains("Your enquiry has been successfully sent to the store owner."));

        // Print the text of the success message to the console
        System.out.println("this is the WebElement Text = " + successMsg.getText());

        // Assert all soft assertions
        soft.assertAll();
    }
}
