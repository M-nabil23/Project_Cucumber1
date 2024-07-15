package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.loginPage;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class login {

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
        login.password.sendKeys(signUp.password);
    }

    @And("user click on loginButton in Login Page")
    public void userClickOnLoginButtonInLoginPage() {
        login.loginButtonInLoginPage.click();

    }

    @Then("user Login successfully")
    public void userLoginSuccessfully() {


    }
}
