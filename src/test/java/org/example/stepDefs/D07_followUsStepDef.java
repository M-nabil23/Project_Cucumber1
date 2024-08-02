package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class D07_followUsStepDef
{

    homePage home = new homePage();
    SoftAssert soft = new SoftAssert();
    @Given("the user clicks on facebook Icon")
    public void theUserClicksOnFacebookIcon()
    {
        home.faceBookIcon.click();
    }


    @Then("the user should redirected to the facebook page {string}")
    public void theUserShouldRedirectedToTheFacebookPage(String arg0)
    {

        //1st- using explicit wait to make sure that it doesn't get the id of the tabs before it make sure that the count of tabs is 2
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // 2nd- you need to make array list of string for tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        int count = tabs.size();
        System.out.println("this is the count of the tabs: " + count);

        System.out.println("this is the current url of the tab before getting window 1: " + driver.getCurrentUrl());

        //3rd- switching to another window/tab
        driver.switchTo().window(tabs.get(1));

        System.out.println("this is the current url of the tab after getting window 1: " + driver.getCurrentUrl());

        //Assertion that the current url is contained with the provided or expected url

        soft.assertTrue(driver.getCurrentUrl().contains(arg0));

        // closing this new tab
        driver.close();

        // redirecting or switching to the first tab
        driver.switchTo().window(tabs.get(0));

        System.out.println("this is the current url of the tab after switching back to tab 0 : " + driver.getCurrentUrl());
    }



    @Given("the user clicks on twitter Icon")
    public void theUserClicksOnTwitterIcon()
    {
        home.twitterIcon.click();
    }

    @Then("the user should redirected to the twitter page {string}")
    public void theUserShouldRedirectedToTheTwitterPage(String arg0) {

        //1st- using explicit wait to make sure that it doesn't get the id of the tabs before it make sure that the count of tabs is 2
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // 2nd- you need to make array list of string for tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        int count = tabs.size();
        System.out.println("this is the count of the tabs: " + count);

        System.out.println("this is the current url of the tab before getting window 1: " + driver.getCurrentUrl());

        //3rd- switching to another window/tab
        driver.switchTo().window(tabs.get(1));

        System.out.println("this is the current url of the tab after getting window 1: " + driver.getCurrentUrl());

        //Assertion that the current url is contained with the provided or expected url
        soft.assertTrue(driver.getCurrentUrl().contains(arg0));

        // closing this new tab
        driver.close();

        // redirecting or switching to the first tab
        driver.switchTo().window(tabs.get(0));

        System.out.println("this is the current url of the tab after switching back to tab 0 : " + driver.getCurrentUrl());
    }

    @Given("the user clicks on rss Icon")
    public void theUserClicksOnRssIcon()
    {
        home.rssIcon.click();
    }

    @Then("the user should redirected to the rss page {string}")
    public void theUserShouldRedirectedToTheRssPage(String arg0) {



        //1st- using explicit wait to make sure that it doesn't get the id of the tabs before it make sure that the count of tabs is 2
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // 2nd- you need to make array list of string for tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        int count = tabs.size();
        System.out.println("this is the count of the tabs: " + count);

        System.out.println("this is the current url of the tab before getting window 1: " + driver.getCurrentUrl());

        //3rd- switching to another window/tab
        driver.switchTo().window(tabs.get(1));

        System.out.println("this is the current url of the tab after getting window 1: " + driver.getCurrentUrl());

        //Assertion that the current url is contained with the provided or expected url
        soft.assertTrue(driver.getCurrentUrl().contains(arg0));

        // closing this new tab
        driver.close();

        // redirecting or switching to the first tab
        driver.switchTo().window(tabs.get(0));

        System.out.println("this is the current url of the tab after switching back to tab 0 : " + driver.getCurrentUrl());
    }

    @Given("the user clicks on youtube Icon")
    public void theUserClicksOnYoutubeIcon()
    {
        home.youTubeIcon.click();
    }

    @Then("the user should redirected to the youtube page {string}")
    public void theUserShouldRedirectedToTheYoutubePage(String arg0) {

        //1st- using explicit wait to make sure that it doesn't get the id of the tabs before it make sure that the count of tabs is 2
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // 2nd- you need to make array list of string for tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        int count = tabs.size();
        System.out.println("this is the count of the tabs: " + count);

        System.out.println("this is the current url of the tab before getting window 1: " + driver.getCurrentUrl());

        //3rd- switching to another window/tab
        driver.switchTo().window(tabs.get(1));

        System.out.println("this is the current url of the tab after getting window 1: " + driver.getCurrentUrl());

        //Assertion that the current url is contained with the provided or expected url
        soft.assertTrue(driver.getCurrentUrl().contains(arg0));

        // closing this new tab
        driver.close();

        // redirecting or switching to the first tab
        driver.switchTo().window(tabs.get(0));

        System.out.println("this is the current url of the tab after switching back to tab 0 : " + driver.getCurrentUrl());
    }








}
