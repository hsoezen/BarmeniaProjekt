package probe;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.LoginPageTestBase;
import utilities.*;

public class FehlerEx extends TestBaseThread {

    @Test
    public void probe() throws InterruptedException {
        LoginPageTestBase loginPageTestBase = new LoginPageTestBase(threadLocalDriver.get());
        JavascriptExecutor js = (JavascriptExecutor) threadLocalDriver.get();

        threadLocalDriver.get().get(ConfigReader.getProperty("base_url"));

        try {
            WebElement shadowCookies= (WebElement) js.executeScript("return document.querySelector(\"#usercentrics-root\").shadowRoot.querySelector(\"#uc-center-container > div.sc-jJoQJp.dTzACB > div > div.sc-bBHxTw.hgPqkm > div > button.sc-gsDKAQ.bSyuWe\")");
            shadowCookies.click();
        }catch (Exception e){
            System.out.println("Das Element ist nicht verfügbar!");
        }

       loginPageTestBase.kundenPortalButton.click();
    }
    @Test

    public void probe2() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) threadLocalDriver.get();
        threadLocalDriver.get().get(ConfigReader.getProperty("base_url"));

        try {
            WebElement shadowCookies= (WebElement) js.executeScript("return document.querySelector(\"#usercentrics-root\").shadowRoot.querySelector(\"#uc-center-container > div.sc-jJoQJp.dTzACB > div > div.sc-bBHxTw.hgPqkm > div > button.sc-gsDKAQ.bSyuWe\")");
            shadowCookies.click();
        }catch (Exception e){
            System.out.println("Das Element ist nicht verfügbar!");
        }

    }
}
