package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.BasePage;
import framework.webPages.RegisterPage;
import framework.webPages.DarkSkyApiPage;
import framework.webPages.LandingPageDarkSky;
import org.testng.Assert;

public class DarkSkySD {
    LandingPageDarkSky landingPageDarkSky = new LandingPageDarkSky();
    RegisterPage registerPage = new RegisterPage();
    BasePage basePage = new BasePage();
    DarkSkyApiPage darkSkyApiPage = new DarkSkyApiPage();


    @Given("^I am on DarkSky home page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY");

    }

    @Given("^I am on register page$")
    public void goToRegisterPage() {
        landingPageDarkSky.clickDarkSkyApi();
        darkSkyApiPage.clickSignUp();
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky API: Register");

    }


    @When("^I click on register button$")
    public void registerButton() {
        registerPage.clickRegister();
    }


    @Then("^I verify error message$")
    public void verifyErrorMessage() {
        registerPage.checkMessage();
       Assert.assertEquals(registerPage.checkMessage(), "Please fill out this field.");

    }


    @Then("^I verify current temperature is not greater or less then temps from daily timeline$")
    public void verifyCurrentTempsToHighLow() {
       landingPageDarkSky.compareTemperature();
    Assert.assertTrue(landingPageDarkSky.compareTemperature());


    }


    @When("^I expand today's timeline$")
    public void expandTimeline() throws InterruptedException {
        landingPageDarkSky.clickOnToday();
    }


    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verify() {
        Assert.assertTrue(landingPageDarkSky.isDisplayAvailable());


    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void timeLineDisplay(){
//        landingPageDarkSky.compareTimeIncrements();
        Assert.assertTrue(landingPageDarkSky.isTimeIncremented());
    }



    }



