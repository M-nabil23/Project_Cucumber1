package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class D09_newsAndNewsSectionStepDef {

    SoftAssert soft = new SoftAssert();

    homePage home = new homePage();

    @When("The user scroll Down to the news section then Click on details")
    public void TheUserScrollDownToTheNewsSectionThenClickOnDetailsBtn() throws InterruptedException {
        WebElement element = driver.findElement(By.className("news-list-homepage"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);



    }


    @Then("The user should find the data is the same as outside")
    public void theUserShouldFindTheDataIsTheSameAsOutside()
    {

        String newsDetails = home.newsBody.getText();
        String newsDate =  home.newsDate.getText();
        String newsTitle =  home.newsTitle.getText();

        home.newsDetailsBtnInHomePage.click();

            String pageNewsDetails = home.pageNewsParagraph.getText();
            String pageNewsDate =  home.pageNewsDate.getText();
            String pageNewsTitle =  home.pageNewsTitle.getText();

        soft.assertTrue(pageNewsTitle.contains(newsTitle));


//
//        soft.assertTrue(pageNewsDate.contains(newsDate));
//        System.out.println(newsDate);
//        System.out.println(pageNewsDate);
//
//        soft.assertTrue(pageNewsDetails.contains(newsDetails));
//        System.out.println(newsDetails);
//        System.out.println(pageNewsDetails);

      //  driver.navigate().back();


        soft.assertAll();
        }


       // WebDriverWait wait = new WebDriverWait(wd, 20); //Wait time of 20 seconds

//
//    /*Getting the list of items again so that when the page is
//     navigated back to, then the list of items will be refreshed
//     again */
//            //listofItems = wd.findElements(By.xpath("//*[starts-with(@id,'result_')]//div//div[1]//div//a//img"));
//
//            //Waiting for the element to be visible
//            //Used (i-1) because the list's item start with 0th index, like in an array
//            wait.until(ExpectedConditions.visibilityOf(listofItems.get(i-1)));
//
//            //Clicking on the first element
//            listofItems.get(i-1).click();
//            wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            System.out.print(i + " element clicked\t--");
//            System.out.println("pass");
//            wd.navigate().back();
        }
