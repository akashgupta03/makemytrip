package pages;

import com.google.common.base.CharMatcher;
import driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FlightSearchResultPage extends BasePage {

    public FlightSearchResultPage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "multiDropDownVal")
    private WebElement tripType;

    @FindBy(id = "fromCity")
    private WebElement fromCity;

    @FindBy(id = "toCity")
    private WebElement toCity;

    @FindBy(id = "departure")
    private WebElement departureDate;

    @FindBy(id = "return")
    private WebElement returnDate;


    @FindBy(id = "travellerAndClass")
    private WebElement travellerAndClass;

    @FindBy(css = "#ow-domrt-jrny .fli-list:nth-child(2)")
    private WebElement departureFlightFromSearchResult;

    @FindBy(css = "#rt-domrt-jrny .fli-list:nth-child(2)")
    private WebElement returnFlightFromSearchResult;

    @FindBy(css = "button.fli_primary_btn")
    private WebElement bookNowButton;


    public void isTripTypeDisplay(String trip) {
        waitForElementToBeDisplay(tripType);
        Assert.assertTrue(tripType.isDisplayed(), "trip type is not display");
        Assert.assertEquals(tripType.getText(), trip, "trip type is not display");
    }

    public void isSourceCityDisplay(String sourceCity) {
        waitForPageToLoad();
        waitForElementToBeDisplay(fromCity);
        Assert.assertTrue(fromCity.isDisplayed(), "trip type is not display");
        Assert.assertEquals(fromCity.getAttribute("value").split(",")[0], sourceCity, String.format("user selected %s but in result page %s display", sourceCity, fromCity.getText()));
    }

    public void isDestinationCityDisplay(String destination) {
        waitForElementToBeDisplay(toCity);
        Assert.assertTrue(toCity.isDisplayed(), "trip type is not display");
        Assert.assertEquals(toCity.getAttribute("value").split(",")[0], destination, String.format("user selected %s but in result page %s display", destination, toCity.getText()));
    }


    public void isPassengerCellDisplay(int passengerCount) {
        waitForElementToBeDisplay(travellerAndClass);
        Assert.assertTrue(travellerAndClass.isDisplayed(), "traveller and class cell is not display");
        int passenger = Integer.parseInt(CharMatcher.inRange('0', '9').retainFrom(travellerAndClass.getAttribute("value")));
        Assert.assertEquals(passenger, passengerCount, String.format("user selected %s passenger but in result page %s passenger display", passengerCount, passenger));
    }


    public void selectDepartureFlightFromSearchResult() {
        waitForElementToBeDisplay(departureFlightFromSearchResult);
        jsClick(departureFlightFromSearchResult);
        wait(2000);

    }

    public void selectReturnFlightFromSearchResult() {
        waitForElementToBeDisplay(returnFlightFromSearchResult);
        jsClick(returnFlightFromSearchResult);
        wait(2000);
    }


    public void verifyBookNowButtonIsDiSplay() {
        waitForElementToBeDisplay(bookNowButton);
        Assert.assertTrue(bookNowButton.isDisplayed(), "book now button is not display on flight search result page");
    }

    public void bookFlight() {
        waitForElementToBeDisplay(bookNowButton);
        jsClick(bookNowButton);
    }

}
