package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverDocker {
    private DriverDocker() {

    }

    static private WebDriver driver;
    static private String HUB_URL = "http://localhost:4444";

    static public WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName("chrome");

            driver = new RemoteWebDriver(new URL(HUB_URL), desiredCapabilities);

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        return driver;
    }

    static public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
/*
public class Driver {

    private Driver() {

    }
    static private WebDriver driver;

    static public WebDriver getDriver() {
        if (driver == null) {

            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        return driver;
    }
    static public void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
*/