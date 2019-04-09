package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.Hotel.HotelHomepage;
import framework.Hotel.HotelResult;
import framework.Hotel.SearchAndFlight;
import org.testng.Assert;

public class HotelSD {
    HotelHomepage hotelHomepage = new HotelHomepage();
    HotelResult hotelResult = new HotelResult();
    SearchAndFlight searchAndFlight = new SearchAndFlight();

    @Given("^I am on Hotel.com homepage$")
    public void iamOnHomepage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations");

    }

    @And("^I proceed to search and flight page$")
    public void proceedToPackageAndFlightPage() {
        hotelHomepage.clickOnPackageAndFlights();
    }

    @And("^I enter (.+) into (origin|destination) textfield$")
    public void enterDataintoTextField(String anyText, String textFields) throws InterruptedException {
        switch (textFields) {
            case "origin":
                searchAndFlight.enterDeparture(anyText);
                break;
            case "destination":
                searchAndFlight.enterFinalDestination(anyText);
                break;
        }
    }

    @And("^I enter (.+) into (departure|returning) datefield$")
    public void enterDates(String dates, String textFields) throws InterruptedException {
        switch (textFields) {
            case "Departing Date":
                searchAndFlight.enterDepartingDate(dates);
                break;

            case "Returning Date":
                searchAndFlight.enterReturningDare(dates);
                break;
        }
    }

    @Then("^I proceed to result page$")
    public void proceedToResultPage() {
        searchAndFlight.clickOnSearchButton();
    }


    //Main Tasks

    @Given("^I am on default locations search result screen$")
    public void iamOnResultPage() {
        Assert.assertTrue(SharedSD.getDriver().getTitle().contains("Hotel Search Results"));
    }

    @When("^I select (.+) from property class$")
    public void selectStars(String stars) {
        switch (stars) {
            case "5 stars":
                hotelResult.selectStarBox("5");
                break;
            case "4 stars":
                hotelResult.selectStarBox("4");
                break;
            case "3 stars":
                hotelResult.selectStarBox("3");
                break;
        }
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void verifyStars(String verifyHotelStars) {
        switch (verifyHotelStars) {
            case "5 stars":
                Assert.assertTrue(hotelResult.verificationOfHotelRatings("5"), "Result displays other stars as well");
                break;
            case "4 stars":
                Assert.assertTrue(hotelResult.verificationOfHotelRatings("4"), "Result is not only displaying 4 stars");
                break;
            case "3 stars":
                Assert.assertTrue(hotelResult.verificationOfHotelRatings("3"), "Result is not only displaying 3 stars");
                break;
        }
    }

    //SubTask 2

    @Then("I verify system displays all hotels within (.+) miles radius of airport")
    public void hotelsAreDisplayedWithin10miles (String miles) {
        switch (miles) {
            case "10 miles":
                hotelResult.hotelAndDistance();
                break;
        }


    }

    @And("I verify (.+) is within radius")
    public void hotelIsListed (String hotelNames) {
        switch (hotelNames) {
            case "Hilton Hotel":
            Assert.assertTrue(hotelResult.isContainHotelName(),"Hotel is not listed");
            break;
        }
    }

}















