package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class headerContent extends pageBasePage {

        @FindBy(className = "ico-logout")
        public WebElement logoutTab;

        @FindBy(className = "ico-register")
        public WebElement registerTab;

        @FindBy(className = "ico-login")
        public WebElement loginTab;
}
