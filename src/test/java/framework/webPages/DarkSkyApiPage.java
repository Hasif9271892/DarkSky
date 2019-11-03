package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyApiPage extends BasePage {

    private By signUpClick = By.partialLinkText("Sign");

    public void clickSignUp(){
        clickOn(signUpClick);
    }
}
