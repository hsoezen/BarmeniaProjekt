package docker;

import org.bouncycastle.jcajce.provider.symmetric.DES;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerTest3 {
    public static void main(String[] args) throws MalformedURLException {

        String HUB_URL="http://localhost:4444";

        DesiredCapabilities desiredCapabilities =new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");

        RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB_URL),desiredCapabilities);

        driver.get("https://www.fincon.eu");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
