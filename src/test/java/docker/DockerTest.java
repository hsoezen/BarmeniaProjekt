package docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DockerTest {
    WebDriver driver;
    static final String APP_URL = "https://www.google.com";
    static final String HOST_URL = "http://localhost:4444"; //chrome
    //static final String HOST_URL = "http://localhost:4441"; //firefox

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();

        driver = new RemoteWebDriver(new URL(HOST_URL), options);
    }

    @Test
    public void test1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(APP_URL);
        System.out.println("Hallo von ");
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
