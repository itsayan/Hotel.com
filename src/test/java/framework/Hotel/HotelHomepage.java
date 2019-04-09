package framework.Hotel;

import framework.BasePage;
import org.openqa.selenium.By;

public class HotelHomepage extends BasePage {

    private By packagesAndFlights = By.id("hdr-packages");



    public void clickOnPackageAndFlights () {
        clickOn(packagesAndFlights);
    }
}
