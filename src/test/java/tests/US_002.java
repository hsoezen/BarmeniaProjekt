package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.net.MalformedURLException;

public class US_002 {
    LoginPage loginPage = new LoginPage();

    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    public US_002() throws MalformedURLException {
    }

    @Test
    public void test1() throws Exception {

        Driver.getDriver().get(ConfigReader.getProperty("base_url"));

        Thread.sleep(3000);
        try {
            WebElement sh = (WebElement) js.executeScript("return " + ConfigReader.getProperty("einwilligung_cookies_shadow"));
            sh.click();
        } catch (Exception e) {
            System.out.println("Hallo US_002");
        }
        loginPage.kundenPortalButton.click();

        loginPage.webWersion.click();
        Driver.closeDriver();

    }

    @Test
    public void test2() throws Exception {

        Driver.getDriver().get(ConfigReader.getProperty("base_url"));

        Thread.sleep(3000);
        try {
            WebElement sh = (WebElement) js.executeScript("return " + ConfigReader.getProperty("einwilligung_cookies_shadow"));
            sh.click();
        } catch (Exception e) {
            System.out.println("Hallo US_002");
        }
        loginPage.kundenPortalButton.click();

        loginPage.webWersion.click();
        Driver.closeDriver();

    }
}
