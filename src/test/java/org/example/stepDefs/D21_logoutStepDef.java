package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.headerContent;
import org.example.pages.homePage;
import org.example.pages.registerPage;
import org.example.pages.registerResultPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D21_logoutStepDef {

    homePage home = new homePage();
    registerPage register = new registerPage();
    registerResultPage registerResult = new registerResultPage();
    SoftAssert soft = new SoftAssert();
    headerContent header = new headerContent();

    @Given("The user go to signup page")
    public void TheUserGoToSignupPage()
    {
        header.registerTab.click();
    }


    @And("The user register a new account")
    public void theUserRegisterANewAccount()
    {
        //user selects his gender
        register.gender.click();

        //user enter his name
        register.firstName.sendKeys("Ahmed");
        register.lastName.sendKeys("Nabil");

        //user select his birthday Date
        //Selecting Day
        WebElement parentDay = register.dateOfBirthDay;
        Select birthDay = new Select(parentDay);
        var minDay =1;
        var maxDay = 31;
        int randomDayNum = minDay + (int)(Math.random() * (maxDay - minDay + 1));
        birthDay.selectByIndex(randomDayNum);

        //SelectingMonth
        WebElement parentMonth = register.dateOfBirthMonth;
        Select birthMonth = new Select(parentMonth);
        var  minMonth =1;
        var  maxMonth = 12;
        int randomMonthNum = minMonth + (int)(Math.random() * (maxMonth - minMonth + 1));
        birthMonth.selectByIndex(randomMonthNum);

        //Selecting Year
        WebElement parentYear = register.dateOfBirthYear;
        Select birthYear = new Select(parentYear);
        var minYear =1;
        var maxYear = 110;
        int randomYearNum = minYear + (int)(Math.random() * (maxYear - minYear + 1));
        birthYear.selectByIndex(randomYearNum);


        //user enter fake email address
        Faker fake = new Faker();
        String  email = fake.internet().emailAddress();
        register.email.sendKeys(email);

        //user enter his Company name
        register.company.sendKeys("Freelancer");


        // user select the newsletter
        //it means if this check box is not selected go into the if and make the action which is clicked
        if(!register.newsletter.isSelected()) {
            register.newsletter.click();
        }

        boolean NewsLetterIsEnabled = register.newsletter.isEnabled();
        soft.assertTrue(NewsLetterIsEnabled);

        boolean NewsLetterIsDisplayed = register.newsletter.isDisplayed();
        soft.assertTrue(NewsLetterIsDisplayed);


        //user enter fake password and confirm password
        Faker fakePassword = new Faker();
        String passwordFake = fakePassword.internet().password();
        register.password.sendKeys(passwordFake);
        register.confirmPassword.sendKeys(passwordFake);

        //user submit the form
        register.registerButton.click();


        //Assertion for alert Text
        String ActualTResultMsg = registerResult.resultText.getText();
        boolean ExpectedResultMsg = ActualTResultMsg.contains("Your registration completed");
        soft.assertTrue(ExpectedResultMsg);

        //Assertion for alert text exactly the same as above
        soft.assertEquals(registerResult.resultText.getText(),"Your registration completed");

        //Assertion for Continue Btn is Displayed
        boolean  ContinueBtnIsDisplayed = registerResult.continueBtn.isDisplayed();
        soft.assertTrue(ContinueBtnIsDisplayed);

        //Assertion for Logout Btn is Displayed
        boolean  LogOutBtnIsDisplayed = registerResult.logOutBtn.isDisplayed();
        soft.assertTrue(LogOutBtnIsDisplayed);

        //Assertion for the alert background is green
        String actualTextColor = registerResult.resultText.getCssValue("color");
        String ExpectedTExtColor = "rgba(76, 177, 124, 1)";
        soft.assertEquals(ExpectedTExtColor,actualTextColor);

        soft.assertAll();
    }

    @When("The user logout by clicking on the logout Button from header")
    public void theUserLogoutByClickingOnTheLogoutButtonFromHeader()
    {
        header.logoutTab.click();
    }

    @Then("The user should be logout Successfully")
    public void theUserShouldBeLogoutSuccessfully()
    {

        soft.assertTrue(header.loginTab.isDisplayed());

        soft.assertAll();
    }
}
