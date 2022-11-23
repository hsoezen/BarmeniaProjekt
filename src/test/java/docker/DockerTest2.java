package docker;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerTest2 {
    @Test
            public void dockerTest() throws MalformedURLException, InterruptedException {
        WebDriver driver =null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        System.out.println("Hallo");

        driver = new RemoteWebDriver(new URL("http://localhost:4441"), desiredCapabilities );

        System.out.println("Hallo2");

        Thread.sleep(2000);
        System.out.println("Hallo3");

        driver.get("https://www.fincon.eu");

        System.out.println(driver.getTitle());
    }

}
