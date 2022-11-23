package testsThread;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPageTestBase;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseThread;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class US_001_TC_001_Registirierung_mit_gueltigen_Daten extends TestBaseThread {

    @Test()
    public void TC_001_Registirierung_mit_gueltigen_Daten() throws InterruptedException, IOException {
        LoginPageTestBase loginPageTestBase = new LoginPageTestBase(threadLocalDriver.get());
        Thread.sleep(3000);
        Actions actions = new Actions(threadLocalDriver.get());
        WebDriverWait wait = new WebDriverWait(threadLocalDriver.get(), Duration.ofSeconds(10));


        threadLocalDriver.get().get(ConfigReader.getProperty("base_url"));

        //ReusableMethods.waitExpilicit(threadLocalDriver.get(), ReusableMethods.shadowCookies(threadLocalDriver.get(),"registirierung_cookies_shadow" ));
       ReusableMethods.shadowCookies(threadLocalDriver.get(), "registirierung_cookies_shadow").click();

        loginPageTestBase.kundenPortalButton.click();

        loginPageTestBase.webWersion.click();

        loginPageTestBase.registrierungButton.click();

        ReusableMethods.shadowCookies(threadLocalDriver.get(), "registirierung_cookies_shadow").click();

        loginPageTestBase.emailTextFeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltige_email_registerierung")).perform();

        loginPageTestBase.benutzernameTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiger_benutzername_registirierung")).perform();

        loginPageTestBase.passwortTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiges_passwort")).perform();

        loginPageTestBase.passwortWiederholungTextfeld.click();
        actions.sendKeys(ConfigReader.getProperty("gueltiges_passwort")).perform();

        loginPageTestBase.nutzungsbedingungenCheckBox.click();

        loginPageTestBase.jetzRegisterButton.click();

        //Assert.assertTrue(loginPageTestBase.registrierungsMeldung.getText().contains(ConfigReader.getProperty("titel_registirierung_meldung")));
        ReusableMethods.getScreenshots(threadLocalDriver.get(), "US_001_TC_001");
        System.out.println("DockerJenkinsTest");
    }
}
