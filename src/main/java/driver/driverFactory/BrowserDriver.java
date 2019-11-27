package driver.driverFactory;

import org.openqa.selenium.WebDriver;

public interface BrowserDriver {

    String driverEnvironment = System.getProperty("driverEnvironment");
    String driver = System.getProperty("driver");
    WebDriver getDriver() throws Exception;
    void setDriverBinaryPath();
}
