package probe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class WarumNichtParallel {

    WebDriver driver;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public void afterClass() {

    }

    @BeforeMethod
    public void driverSet() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() throws Exception {
        driver.get("https://www.google.com");

    }

    @Test
    public void test2() throws Exception {

        driver.get("https://www.google.com");

    }

    @Test
    public void test3() throws Exception {

        driver.get("https://www.google.com");

    }
}