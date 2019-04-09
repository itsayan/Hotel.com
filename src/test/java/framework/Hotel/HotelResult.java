package framework.Hotel;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelResult extends BasePage {
    String starsCommonXpath = "star";
    String hotelName = "Hilton Hotel";
    Double distanceRadius = 10.0;
    private By moreButtonfromNeighborhood = By.xpath("//div[@id='neighborhoodContainer']//fieldset[@class='filterContainer']//details[@class='filterDetails']//a//span[@class='more']");
    private By orlandoMCOAirport = By.id("neighborhood19");
    private By hotelStarRatings = By.xpath("//ul[@class='hotel-info']//li[@class='starRating secondary']");
    private By distanceDetails = By.xpath("//ul[@class='hotel-info']//li[@class='distance secondary tabAccess']");
    private By hotelNames = By.xpath("//h4[@class='hotelName fakeLink']");




    public void selectStarBox(String stars) {
        clickOn(By.id(starsCommonXpath+stars));
    }

    public boolean verificationOfHotelRatings(String stars) {

        boolean areHotelStarsDisplayed = false;
        List<WebElement> allHotels = SharedSD.getDriver().findElements(hotelStarRatings);
        ArrayList<String> strAllHotels = new ArrayList<>();
        for (WebElement element : allHotels) {
            strAllHotels.add(element.getText());
            if (strAllHotels.equals(stars+"0. out of 5.0")) {
                areHotelStarsDisplayed = true;
                break;
            }
        }
        return areHotelStarsDisplayed;
    }


    //locating all the hotels withing 10 miles distance.

    public void selectAirportFromDropDown() throws InterruptedException {
        scrollIntoView(moreButtonfromNeighborhood);
        clickOn(orlandoMCOAirport);

    }

    public ArrayList<Double> distanceFromAirport () {
        List<WebElement> distanceFromAirport = SharedSD.getDriver().findElements(distanceDetails);
        ArrayList<String> strDistanceFromAirport = new ArrayList<>();
        for (WebElement element : distanceFromAirport) {
            String[] newElement = element.getText().split(" km");
            strDistanceFromAirport.add(newElement[0]);
        }
        ArrayList<Double> doubleDistanceFromAirport = new ArrayList<>();
        for (String element : strDistanceFromAirport) {
            doubleDistanceFromAirport.add(Double.valueOf(element));
        }
        return doubleDistanceFromAirport;
    }

    public ArrayList<String> stringHotelNames(){
            List<WebElement> nameOfAllHotels = SharedSD.getDriver().findElements(hotelNames);
            ArrayList<String> strNameOfAllHotels = new ArrayList<>();
            for (WebElement element : nameOfAllHotels) {
                strNameOfAllHotels.add(element.getText());
            }return strNameOfAllHotels;
        }

    public HashMap<String,Double> hotelAndDistance () {
        HashMap<String,Double> hashMap = new HashMap<>();
        for (int i =0; i<stringHotelNames().size(); i++) {
            if (distanceFromAirport().get(i)<=distanceRadius) {
                hashMap.put(stringHotelNames().get(i),distanceFromAirport().get(i));
            }
        }return hashMap;

    }

    //Verifying if Hilton Hotel is listed

    public boolean isContainHotelName () {
        boolean isHotelListed = false;
        for (Map.Entry<String,Double> element: hotelAndDistance().entrySet()){
            if (element.getKey().contains(hotelName));
            isHotelListed= true;

        } return isHotelListed;
    }
}













