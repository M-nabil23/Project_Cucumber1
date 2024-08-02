package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class searchDetailsPage extends pageBasePage {

    @FindBy(className = "item-box")
    public List<WebElement> numberOfItemsInTheSearchResult;

    @FindBy(css = "h2[class=product-title] > a")
    public List<WebElement> productName;

    @FindBy(css = "div[class=\"picture\"]")
    public WebElement productPic;


}