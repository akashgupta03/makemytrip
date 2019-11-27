package testCases;

import annotation.Author;
import annotation.TestCaseNotes;
import constant.TripType;
import org.testng.annotations.Test;
import testBase.TestBase;
import utils.Categories;
import utils.Properties;

import static annotation.TesterName.AKASH;

public class FlightBookingTest extends TestBase {
    @Author(name = AKASH)
    @TestCaseNotes(Steps = "https://www.makemytrip.com || select round trip|| enter the  valid source || enter the valid destination|| pic a data||pic the passenger list||search flight", expecatedResult = "flight should be display from source to destination")
    @Test(groups = {Categories.SMOKE})
    public void bookARoundTripFlight() {
        navigateTo(Properties.baseUrl);
        flightBookingPage.isOneWayDisplay();
        flightBookingPage.isRoundTripRadioButtonIsDisplay();
        flightBookingPage.clickOnRoundTripRadioButton();
        flightBookingPage.isFromSourceCityEditTextFieldIsDisplay();
        flightBookingPage.selectSourceCity("Mumbai", "BOM");
        flightBookingPage.isToDestinationCityEditTextFieldIsDisplay();
        flightBookingPage.selectDestinationCity("Goa", "GOI");
        flightBookingPage.selectDepartureDate(2);
        flightBookingPage.selectReturnDat(3);
        flightBookingPage.selectTravellers(1, 1);
        flightBookingPage.isSearchFlightButtonDisplay();
        flightBookingPage.verifyDate();
        flightBookingPage.searchFlight();
        flightSearchResultPage.isTripTypeDisplay(TripType.ROUNDTRIP);
        flightSearchResultPage.isSourceCityDisplay("Mumbai");
        flightSearchResultPage.isDestinationCityDisplay("Goa");
        flightSearchResultPage.isPassengerCellDisplay(2);
        flightSearchResultPage.selectDepartureFlightFromSearchResult();
        flightSearchResultPage.selectReturnFlightFromSearchResult();
        flightSearchResultPage.verifyBookNowButtonIsDiSplay();
        flightSearchResultPage.bookFlight();


    }

}
