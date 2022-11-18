package testsThread;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPageTestBase;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseThread;
import utilities.dataProviders.DataProviderUS_001;

import java.io.IOException;

public class US_001_TC_003_Benutzername_Voraussetzungen extends TestBaseThread {

    @Test(groups = {"smoke", "regression", "login"})

    public void US001_TC_003_Benutzernahme_Voraussetzungen_mindestens_6_Zeichen() {

        LoginPageTestBase loginPageTestBase = new LoginPageTestBase(threadLocalDriver.get());
        Actions actions = new Actions(threadLocalDriver.get());

        threadLocalDriver.get().get(ConfigReader.getProperty("base_url"));

        ReusableMethods.shadowCookies(threadLocalDriver.get(), "einwilligung_cookies_shadow").click();

        loginPageTestBase.kundenPortalButton.click();

        loginPageTestBase.webWersion.click();

        loginPageTestBase.registrierungButton.click();

        ReusableMethods.shadowCookies(threadLocalDriver.get(), "registirierung_cookies_shadow").click();

        loginPageTestBase.emailTextFeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltige_email_registerierung")).perform();

        loginPageTestBase.benutzernameTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("fuenf_stelliger_benutzername")).perform();
        actions.sendKeys(Keys.TAB).perform();

        Assert.assertTrue(loginPageTestBase.minimum6ZeichenMeldung.isDisplayed());

    }
    @Test(groups = {"regression"}, dataProvider = "BenutzerName", dataProviderClass = DataProviderUS_001.class)

    public void US001_TC_003_Benutzernahme_Voraussetzungen_sonderZeichenUsw(String benutzerName) throws IOException {

        LoginPageTestBase loginPageTestBase = new LoginPageTestBase(threadLocalDriver.get());
        Actions actions = new Actions(threadLocalDriver.get());

        threadLocalDriver.get().get(ConfigReader.getProperty("base_url"));

        //ReusableMethods.waitExpilicit(threadLocalDriver.get(), ReusableMethods.shadowCookies(threadLocalDriver.get(), "einwilligung_cookies_shadow"));
        ReusableMethods.shadowCookies(threadLocalDriver.get(), "einwilligung_cookies_shadow").click();

        loginPageTestBase.kundenPortalButton.click();

        loginPageTestBase.webWersion.click();

        loginPageTestBase.registrierungButton.click();

        ReusableMethods.shadowCookies(threadLocalDriver.get(), "registirierung_cookies_shadow").click();

        loginPageTestBase.emailTextFeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltige_email_registerierung")).perform();

        loginPageTestBase.benutzernameTextfeld.click();
        actions.sendKeys(benutzerName).perform();
        actions.sendKeys(Keys.TAB).perform();

        ReusableMethods.getScreenshots(threadLocalDriver.get(), benutzerName);
        Assert.assertTrue(loginPageTestBase.ungueltigerBenutzernameMeldung.isDisplayed());

    }
}
