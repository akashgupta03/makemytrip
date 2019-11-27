package driver;

import driver.driverFactory.ChromeBrowser;
import driver.driverFactory.FirefoxBrowser;
import org.openqa.selenium.WebDriver;
import utils.Browsers;

public class DriverInitializer {

    private String browser;

    public DriverInitializer(String browser) {
        this.browser = browser;
    }

    public WebDriver init() throws Exception {

        WebDriver webDriver = null;

        switch (browser) {

            case Browsers.FIREFOX:
                webDriver = new FirefoxBrowser().getDriver();
                break;
            case Browsers.CHROME:

            default:
                webDriver = new ChromeBrowser().getDriver();
        }

        DriverProvider.setDriver(webDriver);
        return webDriver;
    }

}
