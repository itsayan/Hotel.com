package framework.Hotel;

import framework.BasePage;
import org.openqa.selenium.By;

public class SearchAndFlight extends BasePage {
    private By originField = By.id("package-origin-hp-package");
    private By destinationField = By.id("package-destination-hp-package");
    private By departingDatefield = By.xpath("//input[@id='package-departing-hp-package']");
    private By returningDateField = By.xpath("//input[@id='package-returning-hp-package']");
    private By searchButton = By.id("search-button-hp-package");



    //Enter informations of Search&Flight Field


    public void enterDeparture(String origin) throws InterruptedException {
        Thread.sleep(2000);
        setValue(originField,origin);}

    public void enterFinalDestination (String finalDestination) throws InterruptedException {
        Thread.sleep(2000);
        setValue(destinationField,finalDestination);
    }


    public void enterDepartingDate(String dates) throws InterruptedException {
        clickOn(departingDatefield);
        Thread.sleep(1000);
        setValue(departingDatefield, dates);
    }

    public void enterReturningDare(String dates) throws InterruptedException {
        clickOn(returningDateField);
        Thread.sleep(100);
        setValue(returningDateField, dates);
    }

    public void clickOnSearchButton() {clickOn(searchButton);}
}


