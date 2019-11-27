package pages;

import driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FlightBookingPage extends BasePage {

    @FindBy(css = "li[data-cy='oneWayTrip']")
    private WebElement oneWay;
    @FindBy(css = "li[data-cy='roundTrip']")
    private WebElement roundTrip;
    @FindBy(id = "fromCity")
    private WebElement fromCity;
    @FindBy(css = "input[placeholder='From']")
    private WebElement originDropDown;

    @FindBy(css = "div.makeFlex .calc60")
    private List<WebElement> dropDownCitList;


    @FindBy(id = "toCity")
    private WebElement toCity;
    @FindBy(css = "input[placeholder='To']")
    private WebElement DestinationDropDown;


    @FindBy(css = "p[data-cy='departureDate']")
    private WebElement departureDate;

    @FindBy(css = "p[data-cy='returnDate']")
    private WebElement returnDate;

    @FindBy(css = "label[for='travellers']")
    private WebElement travellers;

    @FindBy(css = ".guestCounter li[data-cy*='children']")
    private List<WebElement> childCounter;

    @FindBy(css = ".guestCounter li[data-cy*='adults']")
    private List<WebElement> adultCounter;

    @FindBy(css = "span[data-cy='travellerText']")
    private WebElement travellerCount;


    @FindBy(css = "button.btnApply")
    private WebElement applyButton;

    @FindBy(css = "a.widgetSearchBtn")
    private WebElement searchFlightButton;


    public FlightBookingPage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }


    public void isOneWayDisplay() {
        waitForElementToBeDisplay(oneWay);
        Assert.assertTrue(oneWay.isDisplayed(), "After landing on home page one way radio button is not display");


    }

    public void clickOneWay() {
        waitForElementToBeDisplay(oneWay);
        jsClick(oneWay);
    }

    public void isRoundTripRadioButtonIsDisplay() {
        waitForElementToBeDisplay(roundTrip);
        Assert.assertTrue(roundTrip.isDisplayed(), "After landing on home page Round Trip Radio Button is not display");


    }


    public void clickOnRoundTripRadioButton() {
        waitForElementToBeDisplay(roundTrip);
        jsClick(roundTrip);
    }


    public void isFromSourceCityEditTextFieldIsDisplay() {
        waitForElementToBeDisplay(fromCity);
        Assert.assertTrue(fromCity.isDisplayed(), "After landing on home page From Source EditText Field is not display");
    }

    public void selectSourceCity(String city, String cityCode) {
        waitForElementToBeDisplay(fromCity);
        fromCity.click();
        originDropDown.sendKeys(cityCode);
        waitForListOfElementToBeDisplay(dropDownCitList);
        dropDownCitList.stream().
                filter(e -> e.getText().contains(city)).findFirst().get().click();
        wait(2000);

        System.out.println(fromCity.getAttribute("value"));
        Assert.assertEquals(fromCity.getAttribute("value"), city, "selected city is not display");

    }

    public void isToDestinationCityEditTextFieldIsDisplay() {
        waitForElementToBeDisplay(toCity);
        Assert.assertTrue(toCity.isDisplayed(), "After landing on home page To Destination City EditText Field is not display");
    }


    public void selectDestinationCity(String city,String cityCode) {
        waitForElementToBeDisplay(toCity);
        //toCity.click();
        DestinationDropDown.sendKeys(cityCode);
        waitForListOfElementToBeDisplay(dropDownCitList);
        dropDownCitList.stream().
                filter(e -> e.getText().contains(city)).findFirst().get().click();
        Assert.assertEquals(toCity.getAttribute("value"), city, "selected city is not display");


    }

    public void selectDepartureDate(int BookingDayFromToday) {
        Date todayDate = new Date();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("EE MMM dd yyyy");
        c.setTime(todayDate);
        c.add(Calendar.DATE, BookingDayFromToday);
        String date = formatter.format(c.getTime());
        driver.findElement(By.cssSelector(String.format("div[aria-label='%s']", date))).click();
    }

    public void selectReturnDat(int returnDayFromToday) {
        Date todayDate = new Date();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("EE MMM dd yyyy");
        c.setTime(todayDate);
        c.add(Calendar.DATE, returnDayFromToday);
        String date = formatter.format(c.getTime());
        driver.findElement(By.cssSelector(String.format("div[aria-label='%s']", date))).click();

    }

    public void verifyDate() {
        waitForElementToBeDisplay(departureDate);
        System.out.println(departureDate.getText());
        System.out.println();
        waitForElementToBeDisplay(returnDate);
        System.out.println(returnDate.getText());

        waitForElementToBeDisplay(travellerCount);
        System.out.println(travellerCount.getText());
    }


    public void selectTravellers(int adult, int children) {
        waitForElementToBeDisplay(travellers);
        jsClick(travellers);
        childCounter.get(children).click();
        adultCounter.get(adult - 1).click();
        waitForElementToBeDisplay(applyButton);
        applyButton.click();
    }


    public void isSearchFlightButtonDisplay() {
        waitForElementToBeDisplay(searchFlightButton);
        Assert.assertTrue(searchFlightButton.isDisplayed(), "search Flight Button is not display");
    }

    public void searchFlight() {
        waitForElementToBeDisplay(searchFlightButton);
        jsClick(searchFlightButton);
    }



}
