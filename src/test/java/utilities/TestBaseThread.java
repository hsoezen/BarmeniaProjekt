package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBaseThread {

    public ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @BeforeClass(groups = {"smoke","login",  "regression"})
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(groups = {"smoke","login", "regression"})
    public void beforeMthd(){

        threadLocalDriver.set(new ChromeDriver());
        threadLocalDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        threadLocalDriver.get().manage().window().maximize();

    }
    @AfterMethod(groups = {"smoke","login", "regression"})
    public void tearDown(){
        threadLocalDriver.get().quit();

    }
    @AfterClass
    public void afterClass(){

    }
}
