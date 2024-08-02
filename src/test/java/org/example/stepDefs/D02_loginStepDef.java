package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.loginPage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D02_loginStepDef {

    loginPage login = new loginPage();
    SoftAssert soft = new SoftAssert();

    @Given("user click on login button")
    public void userClickOnLoginButton(){

        login.loginButton.click();
    }


    @And("user enter his email in login Page")
    public void userEnterHisEmailInLoginPage() throws IOException {

        login.email.sendKeys(configuration.get("email"));
    }

    @And("user enter his password in Login Page")
    public void userEnterHisPasswordInLoginPage() {
        login.password.sendKeys(D01_registerStepDef.password);
    }

    @And("user click on loginButton in Login Page")
    public void userClickOnLoginButtonInLoginPage() {
        login.loginButtonInLoginPage.click();

    }

    @Then("user Login successfully")
    public void userLoginSuccessfully() {


    }

    //Negative Scenario Invalid Email and its assertions
    @Then("user enter his invalid email in login Page")
    public void userEnterHisInvalidEmailInLoginPage()
    {
        Faker fake = new Faker();
      String fakeEmail =  fake.internet().emailAddress();
        login.email.sendKeys(fakeEmail);
    }

    @Then("user gets an error msg and not being able to login")
    public void userGetsAnErrorMsgAndNotBeingAbleToLogin()
    {

        soft.assertEquals(login.errorMsg.getText(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");

         String actualColor = login.errorMsg.getCssValue("color");
         String actualColorInHex = Color.fromString(actualColor).asHex();
        System.out.println(actualColorInHex);
        soft.assertEquals(actualColorInHex,"#e4434b");

        soft.assertAll();
    }
}
