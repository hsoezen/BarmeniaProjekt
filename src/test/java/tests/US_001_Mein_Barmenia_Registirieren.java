package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class US_001_Mein_Barmenia_Registirieren  {

    static LoginPage loginPage = new LoginPage();
    static Actions actions = new Actions(Driver.getDriver());
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Test()

    public void TC_001_Registirierung_mit_gueltigen_Daten() throws InterruptedException, IOException {


        Driver.getDriver().get(ConfigReader.getProperty("base_url"));

        Thread.sleep(3000);
       ReusableMethods.cookiesShadowRootElementClick("alleakzeptieren_cookies_shadow");

       Thread.sleep(6000);
        loginPage.kundenPortalButton.click();

       wait.until(ExpectedConditions.visibilityOf(loginPage.webWersion)).click();

        loginPage.registrierungButton.click();

        ReusableMethods.cookiesShadowRootElementClick("nur_wesentliche_cookies_shadow");

        loginPage.emailTextFeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltige_email_registerierung")).perform();

        loginPage.benutzernameTextfeld.click();

        actions.sendKeys(ConfigReader.getProperty("gueltiger_benutzername_registirierung")).perform();

        loginPage.passwortTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiges_passwort")).perform();

        loginPage.passwortWiederholungTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiges_passwort")).perform();

        loginPage.nutzungsbedingungenCheckBox.click();
        Assert.assertTrue(loginPage.jetzRegisterButton.isDisplayed());


        loginPage.jetzRegisterButton.click();

        //Assert.assertTrue(loginPage.registrierungsMeldung.getText().contains(ConfigReader.getProperty("titel_registirierung_meldung")));

        Driver.closeDriver();
    }


    @Test
    public void TC_002_Die_EMail_Adresse_soll_AT_Zeichen_enthalten() throws Exception {
        LoginPage loginPage = new LoginPage();
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("base_url"));

        ReusableMethods.cookiesShadowRootElementClick("alleakzeptieren_cookies_shadow");

        loginPage.kundenPortalButton.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.webWersion));
        loginPage.webWersion.click();

        Thread.sleep(3000);
        loginPage.registrierungButton.click();

        ReusableMethods.cookiesShadowRootElementClick("nur_wesentliche_cookies_shadow");

        loginPage.emailTextFeld.click();
        actions.sendKeys(ConfigReader.getProperty("email_ohne_At_zeichen")).perform();

        loginPage.benutzernameTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiger_benutzername_registirierung")).perform();

        loginPage.passwortTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiges_passwort")).perform();

        loginPage.nutzungsbedingungenCheckBox.click();

        try {
            Assert.assertTrue(loginPage.jetzRegisterButton.isDisplayed());

        } catch (Exception e) {
            System.out.println("Die Jetzt Registrieren Taste ist nicht sichtbar!");
        }

       Driver.closeDriver();
    }
}
