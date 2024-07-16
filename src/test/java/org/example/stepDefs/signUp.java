package org.example.stepDefs;


import com.github.javafaker.Faker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.example.pages.homePage;
import org.example.pages.registerPage;
import org.example.pages.registerResultPage;

import java.io.IOException;

import static org.example.stepDefs.Hooks.driver;

public class signUp {


    homePage  home = new homePage();
    registerPage register = new registerPage();
    registerResultPage registerResult = new registerResultPage();
    SoftAssert soft = new SoftAssert();

    public static String email;
    public static String password;

    @Given("user go to register page")
    public void userGoToRegisterPage()
    {
//        home.registerButton().click();  // this without using page factory in pages design pom pattern

        home.registerBtn.click();  // this using page factory in pages design pom pattern
    }

    @When("user select his gender")
    public void userSelectHisGender()
    {
        register.gender.click();

        boolean genderIsEnabled =  register.gender.isEnabled();
        soft.assertTrue(genderIsEnabled);

        boolean genderIsDisplayed =  register.gender.isDisplayed();
        soft.assertTrue(genderIsDisplayed);
    }

    @And("user enter his first and his last name")
    public void userEnterHisStAndHisLastName()
    {
        register.firstName.sendKeys("Ahmed");
        register.lastName.sendKeys("Nabil");

    }

    @And("user select his Date of birth")
    public void userSelectHisDateOfBirth() {


        WebElement parentDay = register.dateOfBirthDay;
        Select birthDay = new Select(parentDay);
        var minDay =1;
        var maxDay = 31;
        int randomDayNum = minDay + (int)(Math.random() * (maxDay - minDay + 1));
        birthDay.selectByIndex(randomDayNum);


        WebElement parentMonth = register.dateOfBirthMonth;
        Select birthMonth = new Select(parentMonth);
        var  minMonth =1;
        var  maxMonth = 12;
        int randomMonthNum = minMonth + (int)(Math.random() * (maxMonth - minMonth + 1));
        birthMonth.selectByIndex(randomMonthNum);


        WebElement parentYear = register.dateOfBirthYear;
        Select birthYear = new Select(parentYear);
        var minYear =1;
        var maxYear = 110;
        int randomYearNum = minYear + (int)(Math.random() * (maxYear - minYear + 1));
        birthYear.selectByIndex(randomYearNum);
    }

    @And("user enter his email")
    public void userEnterHisEmail() throws IOException {
        Faker fake = new Faker();
       email = fake.internet().emailAddress();
      configuration.set("email",email);
        register.email.sendKeys(email);

    }
    @And("user enter his company name")
    public void userEnterHisCompanyName()
    {
        register.company.sendKeys("Freelancer");
    }

    @And("user unselect newsLetter")
    public void userUnselectNewsLetter()
    {
        //it means if this check box is not selected go into the if and make the action which is clicked
        if(!register.newsletter.isSelected()) {
            register.newsletter.click();
        }

        boolean NewsLetterIsEnabled = register.newsletter.isEnabled();
        soft.assertTrue(NewsLetterIsEnabled);

        boolean NewsLetterIsDisplayed = register.newsletter.isDisplayed();
        soft.assertTrue(NewsLetterIsDisplayed);

    }

    @And("user enter his password and  confirm password")
    public void userEnterHisPasswordAndConfirmPassword() throws IOException {
        Faker fake = new Faker();
        password = fake.internet().password();
        configuration.set("password",password);
        register.password.sendKeys(password);
        register.confirmPassword.sendKeys(password);

        //another way for the password :  Password = "123123123" then use it  directly without fake.internet then call it in the sendKeys
    }

    @And("user click on register Button")
    public void userClickOnRegisterButton()
    {
        register.registerButton.click();

    }

    @Then("new account is created successfully")
    public void newAccountIsCreatedSuccessfully()
    {
        String ActualTResultMsg = registerResult.resultText.getText();
        boolean ExpectedResultMsg = ActualTResultMsg.contains("Your registration completed");
        soft.assertTrue(ExpectedResultMsg);



        soft.assertEquals(registerResult.resultText.getText(),"Your registration completed");


        boolean  ContinueBtnIsDisplayed = registerResult.continueBtn.isDisplayed();
        soft.assertTrue(ContinueBtnIsDisplayed);


        boolean  LogOutBtnIsDisplayed = registerResult.logOutBtn.isDisplayed();
        soft.assertTrue(LogOutBtnIsDisplayed);

        String actualTextColor = registerResult.resultText.getCssValue("color");
        String ExpectedTExtColor = "rgba(76, 177, 124, 1)";
        soft.assertEquals(ExpectedTExtColor,actualTextColor);


        soft.assertAll();
    }

//Negative Scenario
    @And("user enter his Invalid email")
    public void userEnterHisInvalidEmail() throws InterruptedException {
        var minTestCase = 1;
        var maxTestCaseNumber = 2;
        int testCaseNumber = minTestCase + (int)(Math.random() * (maxTestCaseNumber - minTestCase + 1));
        System.out.println(testCaseNumber);
        Faker fake = new Faker();



        //Negative case email without @ Sign
        try{
        if (testCaseNumber == 1)
        {

            String arg0 = fake.name().firstName();
            driver.findElement(By.name("Email")).sendKeys(arg0 + "ssad.com");
            Thread.sleep(2000);
            throw new Exception("You didn't enter @ sign");
            //Negative case email without .com
        }}catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {


        if (testCaseNumber == 2) {
            String arg0 = fake.name().firstName();
            driver.findElement(By.name("Email")).sendKeys(arg0 + "@ssad");
            Thread.sleep(2000);
            throw new Exception("You didn't enter .com");

        }
        //Negative case email with empty spaces
        } catch (Exception e) {
            throw new RuntimeException(e);


        }

    }

    @Then("new account is not created")
    public void newAccountIsNotCreated() {
       String actualErrorEmailMsg =  register.wrongEmail.getText();
       soft.assertEquals(actualErrorEmailMsg,"Wrong email");
       String actualUrl = driver.getCurrentUrl();
       soft.assertEquals(actualUrl,"https://demo.nopcommerce.com/register?returnUrl=%2F");
     soft.assertAll();
    }
}

