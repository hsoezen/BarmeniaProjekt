package docker;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    static final String HOST_URL = "http://localhost:4444";

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        driver = new RemoteWebDriver(new URL(HOST_URL), options);
    }

    @Test
    public void test1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get(APP_URL);
       System.out.print(driver.getTitle());

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
