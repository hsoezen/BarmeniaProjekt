package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Hooks;

public class Test1 extends Hooks{

    LoginPage loginPage = new LoginPage();

    @Test
    public void test1() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        WebElement shadowDom = (WebElement) js.executeScript(ConfigReader.getProperty("alleakzeptieren_cookies_shadow"));
        //shadowDom.click();

        //loginPage.kundenPortalButton.click();
        for (WebElement w: loginPage.serviceNavigation
             ) {
            if (w.getText().equals("Kundenportal")){
                w.click();
                break;
            }
        }

        loginPage.webWersion.click();







    }
}
