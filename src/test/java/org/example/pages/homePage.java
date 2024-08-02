package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class homePage {

    //apply pom pattern without page factory
//    public WebElement registerButton ()
//    {
//        return driver.findElement(By.className("ico-register"));
//    }

    // apply pom pattern with page factory class in selenium  WebDriver no constructor needed

    //Constructor
    public  homePage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "ico-register")
    public WebElement registerBtn;

    @FindBy(id = "small-searchterms")
    public WebElement searchTextField;

    @FindBy(className = "search-box-button")
    public WebElement SearchButton;

    @FindBy(css = "ul[class=\"top-menu notmobile\"]>li")
    public List<WebElement> mainCategories;

    @FindBy(xpath = "(//ul[@class='top-menu notmobile']//ul)[\"+selectedCategory+\"]/li")
    public List<WebElement> mainSubCategories;





    @FindBy(css = "ul[class=\"top-menu notmobile\"]>li")
    public List<WebElement> Categories;


    public List<WebElement> subCategories(int categoryNum)
    {
        categoryNum = categoryNum + 1;
        return Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li:nth-child("+categoryNum+")>ul[class=\"sublist first-level\"]>li"));

        //        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+categoryNum+"]/ul[@class=\"sublist first-level\"]/li"));
    }

    @FindBy(css = "div[class=\"page category-page\"]")
    public WebElement category_page;

    @FindBy(css = "div[class=\"page-title\"]")
    public WebElement page_title;




    //add to the cart feature
    @FindBy(css = "div[data-productid=\"18\"] > div[class=\"details\"] div[class=\"add-info\"] div[class=\"buttons\"] > button[class$=\"product-box-add-to-cart-button\"]")
    public WebElement addProductToCartBtn;

    @FindBy(css = "a[class=\"ico-cart\"] > span[class=\"cart-label\"]")
    public WebElement goToCartTab;



    @FindBy(css = "li[class=\"facebook\"] > a")
    public WebElement faceBookIcon;

    @FindBy(css = "li[class=\"twitter\"] > a")
    public WebElement twitterIcon;

    @FindBy(css = "li[class=\"rss\"] > a")
    public WebElement rssIcon;

    @FindBy(css = "li[class=\"youtube\"] > a")
    public WebElement youTubeIcon;


    //this is a specific wishList button locator
    @FindBy(css ="div[data-productid=\"18\"] button[class$=\"add-to-wishlist-button\"]")
    public WebElement productWishListButton;

    @FindBy(className = "wishlist-qty")
    public WebElement wishListTabCounter;

    @FindBy(css = "div[class=\"bar-notification success\"] > p")
    public WebElement alert;

    @FindBy(css = "div[class=\"bar-notification success\"]")
    public WebElement alertBackGround;


    @FindBy(className = "ico-wishlist")
    public WebElement wishListTab;


    @FindBy(className = "news-title")
    public WebElement newsTitle;

    @FindBy(className = "news-date")
    public WebElement newsDate;

    @FindBy(className = "news-body")
    public WebElement newsBody;

    @FindBy(className = "news-item")
    public List<WebElement> newsItems;


    @FindBy(className = "read-more")
    public WebElement newsDetailsBtnInHomePage;


    @FindBy(className = "page-title")
    public WebElement pageNewsTitle;

    @FindBy(css = "div[class=page-body] div[class=news-date]")
    public WebElement pageNewsDate;

    @FindBy(css = "div[class=news-body] > p")
    public WebElement pageNewsParagraph;


    @FindBy(className = "home-page-polls")
    public WebElement voteSectionScrollToIt;

    @FindBy(css="li[class=\"answer\"] > input")
    public List<WebElement> voteAnswers;

    @FindBy(className="answer")
    public List<WebElement> voteResult;

    @FindBy(id = "vote-poll-1")
    public WebElement voteSubmitBtn;


    @FindBy(className = "poll-total-votes")
    public WebElement totalVotes;


    @FindBy(className = "poll-vote-error" )
    public WebElement errorVoteMsgForGuests;



    public WebElement sliders(String num)
    {
        return Hooks.driver.findElement(By.cssSelector("a[class=\"nivo-imageLink\"]:nth-child("+num+")"));
    }

}
//a[class="nivo-imageLink"]