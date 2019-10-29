package framework.webPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;


public class RegisterPage extends BasePage {
    LandingPageDarkSky landDarksky = new LandingPageDarkSky();
    DarkSkyApiPage darkSkyApiPage = new DarkSkyApiPage();

    private By registerButton = By.xpath("//button[contains(text(),'Register')]");
    //private By signUpButton = By.linkText("Sign Up");
   private By emailField = By.xpath("//input[@placeholder='hacker@example.com']");
   // private By emailField = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/input[1]");



    public void clickRegister() {

        clickOn(registerButton);

    }

    public String checkMessage() {
        WebElement email = webAction(emailField);
        String errorMessage = email.getAttribute("validationMessage");
        return errorMessage;

    }











    }
