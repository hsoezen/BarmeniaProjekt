package tests;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

public class US_001_Mein_Barmenia_Registirieren  extends Hooks{

    LoginPage loginPage = new LoginPage();
    Actions actions = new Actions(Driver.getDriver());

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    ReusableMethods reusableMethods = new ReusableMethods();

    @Test
    public void TC_001_Registirierung_mit_gueltigen_Daten() throws InterruptedException, IOException {

        Driver.getDriver().get(ConfigReader.getProperty("base_url"));

        reusableMethods.shadowRoot("alleakzeptieren_cookies_shadow").click();

        loginPage.kundenPortalButton.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.webWersion)).click();

        loginPage.registrierungButton.click();

        reusableMethods.shadowRoot("registirierung_cookies_shadow").click();

        loginPage.emailTextFeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltige_email_registerierung")).perform();

        loginPage.benutzernameTextfeld.click();

        actions.sendKeys(ConfigReader.getProperty("gueltiger_benutzername_registirierung")).perform();

        loginPage.passwortTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiges_passwort")).perform();

        loginPage.passwortWiederholungTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiges_passwort")).perform();

        loginPage.nutzungsbedingungenCheckBox.click();

        loginPage.jetzRegisterButton.click();

        Assert.assertTrue(loginPage.registrierungsMeldung.getText().contains(ConfigReader.getProperty("titel_registirierung_meldung")));

    }
    @Test
    public void TC_002_Die_EMail_Adresse_soll_AT_Zeichen_enthalten() throws IOException, InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));

        reusableMethods.shadowRoot("registirierung_cookies_shadow").click();

        loginPage.kundenPortalButton.click();

        loginPage.webWersion.click();

        loginPage.registrierungButton.click();

        reusableMethods.shadowRoot("registirierung_cookies_shadow").click();

        loginPage.emailTextFeld.click();
        actions.sendKeys(ConfigReader.getProperty("email_ohne_At_zeichen")).perform();

        loginPage.benutzernameTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiger_benutzername_registirierung")).perform();

        loginPage.passwortTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiges_passwort")).perform();

        loginPage.nutzungsbedingungenCheckBox.click();

        try {
            loginPage.jetzRegisterButton.click();
        }
        catch (Exception e){
            System.out.println("Jetzt registrieren Taste ist nicht anklickbar!");
        }
    }
}
