package driver.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements BrowserDriver {

    @Override
    public WebDriver getDriver() throws Exception {
        setDriverBinaryPath();

        return new FirefoxDriver();
    }


    @Override
    public void setDriverBinaryPath() {
        WebDriverManager.firefoxdriver().setup();
    }
}
