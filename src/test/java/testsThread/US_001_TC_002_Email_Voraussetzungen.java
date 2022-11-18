package testsThread;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPageTestBase;
import utilities.ConfigReader;
import utilities.dataProviders.DataProviderUS_001;
import utilities.ReusableMethods;
import utilities.TestBaseThread;

import java.io.IOException;

public class US_001_TC_002_Email_Voraussetzungen extends TestBaseThread {

    @Test(groups = {"smoke"}, dataProvider = "EMail", dataProviderClass = DataProviderUS_001.class)

    public void TC_002_Die_EMail_Adresse_soll_AT_Zeichen_enthalten(String email) throws InterruptedException, IOException {

        LoginPageTestBase loginPageTestBase = new LoginPageTestBase(threadLocalDriver.get());
        Actions actions = new Actions(threadLocalDriver.get());


        threadLocalDriver.get().get(ConfigReader.getProperty("base_url"));

        //ReusableMethods.waitExpilicit(threadLocalDriver.get(), ReusableMethods.shadowCookies(threadLocalDriver.get(), "einwilligung_cookies_shadow"));
        Thread.sleep(1000);
        ReusableMethods.shadowCookies(threadLocalDriver.get(), "einwilligung_cookies_shadow").click();

        loginPageTestBase.kundenPortalButton.click();

        loginPageTestBase.webWersion.click();

        loginPageTestBase.registrierungButton.click();

        ReusableMethods.shadowCookies(threadLocalDriver.get(), "registirierung_cookies_shadow").click();

        loginPageTestBase.emailTextFeld.click();
        actions.sendKeys(email).perform();
        System.out.println(email);

        loginPageTestBase.benutzernameTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiger_benutzername_registirierung")).perform();

        loginPageTestBase.passwortTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiges_passwort")).perform();

        loginPageTestBase.passwortWiederholungTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiges_passwort")).perform();

        loginPageTestBase.nutzungsbedingungenCheckBox.click();

        try {
            Assert.assertTrue(loginPageTestBase.jetzRegisterButton.isDisplayed());
            Thread.sleep(1000);
            ReusableMethods.getScreenshots(threadLocalDriver.get(), email);
            System.out.println("Jetzt-register Schaltfläche ist anklickbar.");

            try {
                loginPageTestBase.jetzRegisterButton.click();
                Assert.assertTrue(loginPageTestBase.tecnischesProblemMeldung.isDisplayed());
                ReusableMethods.getScreenshots(threadLocalDriver.get(), email);

            }catch (Exception e){
                System.out.println("Unerwünschte erforgreiche Registrierungsmeldung!");
                ReusableMethods.getScreenshots(threadLocalDriver.get(), email);
            }

        }catch (Exception e){
            System.out.println("Jetzt register Schaltfläche ist nicht anklickbar!");

            ReusableMethods.getScreenshots(threadLocalDriver.get(), email);
        }

    }
}
