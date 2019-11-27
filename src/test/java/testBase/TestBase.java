package testBase;

import driver.DriverInitializer;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import pages.FlightBookingPage;
import pages.FlightSearchResultPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    protected FlightBookingPage flightBookingPage;
    protected FlightSearchResultPage flightSearchResultPage;
    protected LoginPage loginPage;


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {
        driver = new DriverInitializer(System.getProperty("driver")).init();
        flightBookingPage = new FlightBookingPage();
        flightSearchResultPage = new FlightSearchResultPage();
        loginPage = new LoginPage();

    }

    protected void navigateTo(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //@AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}

