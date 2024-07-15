package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepDefs.Hooks.driver;

public class homePage {

    //apply pom pattern without page factory
    public WebElement registerButton ()
    {
        return driver.findElement(By.className("ico-register"));
    }


    // apply pom pattern with page factory class in selenium  WebDriver no constructor needed

    //Constructor
    public  homePage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "ico-register")
    public WebElement registerBtn;


}
