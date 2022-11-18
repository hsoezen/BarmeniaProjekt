package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverTestNG {

    public DriverTestNG() {

    }

    static private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    static public ThreadLocal<WebDriver> getDriverTestNG() {
        if (threadLocalDriver == null) {
            WebDriverManager.chromedriver().setup();

            threadLocalDriver.set(new ChromeDriver());

            threadLocalDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            threadLocalDriver.get().manage().window().maximize();
        }
        return threadLocalDriver;
    }

    static public void closeTestNG() {

        threadLocalDriver.get().quit();

    }
}

