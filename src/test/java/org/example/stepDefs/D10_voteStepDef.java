package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.example.stepDefs.Hooks.driver;

import org.example.pages.homePage;
import org.example.stepDefs.D01_registerStepDef;
import org.example.stepDefs.D02_loginStepDef;
import org.example.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class D10_voteStepDef {

    homePage home = new homePage();
    D01_registerStepDef register = new D01_registerStepDef();
    D02_loginStepDef login = new D02_loginStepDef();

    SoftAssert soft = new SoftAssert();

    @Given("The user should login first")
    public void TheUserShouldLoginFirst() throws IOException, InterruptedException {
        register.userGoToRegisterPage();
        register.userSelectHisGender();
        register.userEnterHisStAndHisLastName();
        register.userSelectHisDateOfBirth();
        register.userEnterHisEmail();
        register.userEnterHisCompanyName();
        register.userEnterHisPasswordAndConfirmPassword();
        register.userClickOnRegisterButton();

        driver.get("https://demo.nopcommerce.com/");

        WebElement element = home.voteSectionScrollToIt;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    @When("The user Selects on the vote options")
    public void theUserSelectsOnTheVoteOptions()
    {
        int minAnswer = 0;
        int maxAnswer = 3;
        int randomVoteAnswer = minAnswer + (int)(Math.random() * (maxAnswer - minAnswer + 1));

        home.voteAnswers.get(randomVoteAnswer).click();
    }

    @And("The user clicks on vote Button")
    public void theUserClicksOnVoteButton()
    {
        home.voteSubmitBtn.click();
    }

    @Then("The user should gets the results and successfully vote")
    public void theUserShouldGetsTheResultsAndSuccessfullyVote()
    {
        soft.assertTrue(home.totalVotes.getText().contains("vote(s)..."));
        System.out.println("Number of votes " +home.totalVotes.getText());

        for (WebElement e : home.voteResult){
            soft.assertTrue(e.getText().contains("%"));
            System.out.println("All answers are having % sign " +e.getText());
        }
        soft.assertAll();
    }


    @When("The Guest user Selects on the vote options")
    public void theGuestUserSelectsOnTheVoteOptions() throws InterruptedException {
        WebElement element = home.voteSectionScrollToIt;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);


        int randomVote = BrowserUtils.randomNum(0,3);
        home.voteAnswers.get(randomVote).click();

    }

    @Then("The user should not gets results and get validation msg")
    public void theUserShouldNotGetsResultsAndGetValidationMsg()
    {
        // in here we had to use wait to visibility of Element located cuz it stays a only couple of seconds then be hidden
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("poll-vote-error")));
        String actualAlertMsg = home.errorVoteMsgForGuests.getText();
        String expectedErrorText = "Only registered users can vote.";
        soft.assertEquals(actualAlertMsg,expectedErrorText);
        System.out.println(home.errorVoteMsgForGuests.getText());

        // get color then make it into hex
        String actualColor = home.errorVoteMsgForGuests.getCssValue("color");
        System.out.println(actualColor);
        String actualColorInHex = Color.fromString(actualColor).asHex();
        System.out.println(actualColorInHex);
        soft.assertEquals(actualColorInHex,"#e4434b");


        soft.assertAll();


//        another solution :
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        WebElement element = driver.findElement(By.xpath("//input[@id='displayed-text']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','visibility:visible;');",
//                element);
//
//        jse.executeScript("document.getElementById('displayed-text').value='LambdaTest';");
    }


    //Learning how to deal with alerts
    @When("The Guest user clicks on vote Button")
    public void theGuestUserClicksOnVoteButton() throws InterruptedException {
        WebElement element = home.voteSectionScrollToIt;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);


        theUserClicksOnVoteButton();

    }

    @Then("The user should not gets results and get Alert msg")
    public void theUserShouldNotGetsResultsAndGetAlertMsg()
    {   //in here I had got the alert text and made sure that its containing this expected text
        soft.assertTrue(driver.switchTo().alert().getText().contains("Please select an answer"));
        // then I had to click on OK button
        driver.switchTo().alert().accept();

    }
}
