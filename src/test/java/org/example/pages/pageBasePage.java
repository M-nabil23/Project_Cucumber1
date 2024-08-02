package org.example.pages;

import org.openqa.selenium.support.PageFactory;
import static org.example.stepDefs.Hooks.driver;
public class pageBasePage {

    public pageBasePage()
    {
        PageFactory.initElements(driver,this);
    }
}
