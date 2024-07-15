package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepDefs.Hooks.driver;

public class registerPage {



    public registerPage()
    {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "gender-male")
    public WebElement gender;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    public WebElement dateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement dateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement dateOfBirthYear;

    @FindBy(name = "Email")
    public WebElement email;

    @FindBy(name = "Newsletter")
    public WebElement newsletter;

    @FindBy(name = "Company")
    public WebElement company;

    @FindBy(name = "Password")
    public WebElement password;

    @FindBy(name = "ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(name = "register-button")
    public WebElement registerButton;

    @FindBy(id = "Email-error")
    public WebElement wrongEmail;

}
