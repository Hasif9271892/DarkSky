package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelsLandingPage;
import framework.webPages.ResultsHotel;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HotelsSD {
    HotelsLandingPage land = new HotelsLandingPage();
    ResultsHotel results = new ResultsHotel();
    List<String> listOfHotels = new ArrayList<>();

    @Given("^I am on hotels.com home page$")
    public void iAmOnHotelsHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations");
    }

    @When("^I select (.+) from drop down$")
    public void selectSelectRooms(String select_rooms) {

        Select select = new Select(land.rooms());
        select.selectByVisibleText(select_rooms);

    }


    @Then("^I verify (\\d) is displayed$")
    public void verify(int numberOfRooms) {
        Assert.assertEquals(land.roomEntriesCount(), numberOfRooms);

    }

    @Given("^I am on default locations search result screen$")
    public void iAmOnDefaultLocationsSearchResultScreen() throws InterruptedException {
        land.setNyDestination();
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - hotels in New York, New York, United States Of America");
    }

    @When("^I select property class (.+)$")
    public void iSelectPropertyClassStars(String stars) {
        results.starCount(stars);
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void iVerifySystemDisplaysOnlyStarsHotelsOnSearchResult(String stars) throws InterruptedException {
     Assert.assertTrue(results.hasXStars(stars));
    }


    @Then("^I verify system displays all hotels within (\\d+) miles radius of airport$")
    public void iVerifySystemDisplaysAllHotelsWithinMilesRadiusOfAirport(int distance) throws InterruptedException {
        listOfHotels = results.getHotelsWithinSpecifiedRadius(distance);

    }

    @And("^I verify (.+) Hotel is within radius$")
    public void iVerifyGivenHotelIsInRange(String hotelName) throws InterruptedException {
      Boolean isFound = false;
        for (String hotelTitle : listOfHotels) {
            if(hotelTitle.contains(hotelName)){
                isFound=true;
                break;
            }
        }
        Assert.assertTrue(isFound);
    }

    @Then("^I verify today deal is less than \\$(\\d+)$")
    public void iVerifyTodayDealIsLessThan$(int priceNumber) {
        Assert.assertTrue(results.todayDealisLessThan200(priceNumber));
    }
}





