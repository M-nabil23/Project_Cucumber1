package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.homePage;
import org.example.utilities.BrowserUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D05_hoverCategoriesStepDef {

    homePage home = new homePage();

    SoftAssert soft = new SoftAssert();
    String category;

    @Given("The user hover on the main category")
    public void TheUserHoverOnTheMainCategory() throws InterruptedException {

        int categoriesCount = home.Categories.size();
        int categoryNum = BrowserUtils.randomNum(0, categoriesCount-1);
        System.out.println(categoryNum);

        Actions action = new Actions(Hooks.driver);
        action.moveToElement(home.Categories.get(categoryNum)).perform();

        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        if(!home.subCategories(categoryNum).isEmpty())
        {
            int subCategories = home.subCategories(categoryNum).size();
            int subCategoriesNum = BrowserUtils.randomNum(0, subCategories-1);
            this.category = home.subCategories(categoryNum).get(subCategoriesNum).getText().trim();
            System.out.println("Sub categories: "+this.category);
            home.subCategories(categoryNum).get(subCategoriesNum).click();

        }
        else
        {
            this.category = home.Categories.get(categoryNum).getText().trim();
            System.out.println("Main category: "+this.category);
            home.Categories.get(categoryNum).click();

        }
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Then("The user should be see the subCategories Products")
    public void theUserShouldBeSeeTheSubCategoriesProducts()
    {

        soft.assertTrue(home.category_page.isDisplayed());
        soft.assertTrue(home.page_title.getText().toLowerCase().contains(this.category.toLowerCase()));
        soft.assertAll();
    }
}
