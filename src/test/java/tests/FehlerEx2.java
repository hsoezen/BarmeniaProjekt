package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FehlerEx2 extends TestBase {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    @Test
    public void probe() throws Exception {
        driver.get(ConfigReader.getProperty("base_url"));

        Thread.sleep(3000);
        //try {
            WebElement shadowCookies= (WebElement) js.executeScript("return document.querySelector(\"#usercentrics-root\").shadowRoot.querySelector(\"#uc-center-container > div.sc-jJoQJp.dTzACB > div > div.sc-bBHxTw.hgPqkm > div > button.sc-gsDKAQ.bSyuWe\")");
            shadowCookies.click();
       // }catch (Exception e){
            System.out.println("Da Element ist nicht verfügbar!");
       // }

    }
}
