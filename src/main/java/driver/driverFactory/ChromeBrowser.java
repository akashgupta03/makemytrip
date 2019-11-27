package driver.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser implements BrowserDriver {

    @Override
    public WebDriver getDriver() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("allow-running-insecure-content");
        options.addArguments("--start-fullscreen");
        options.addArguments("--disable-notifications");
        setDriverBinaryPath();

        return new ChromeDriver(options);
    }


    public void setDriverBinaryPath() {
        WebDriverManager.chromedriver().setup();

    }

}
