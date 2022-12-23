package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.DriverDocker;

import java.net.MalformedURLException;
import java.util.List;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Kundenportal")
    public WebElement kundenPortalButton;

    @FindBy(xpath = "//div[@class='serviceNavigation']//div")
    public List<WebElement> serviceNavigation;

    @FindBy(partialLinkText = "BarmeniaApp")
    public WebElement barmeniaApp;

    @FindBy(partialLinkText = "Webversion")
    public WebElement webWersion;

    @FindBy(linkText = "Jetzt registrieren")
    public WebElement registrierungButton;

    @FindBy(xpath = "//div[@class='mat-form-field-flex ng-tns-c39-3']")
    public WebElement emailTextFeld;

    @FindBy(xpath = "//div[@class='mat-form-field-flex ng-tns-c39-4']")
    public WebElement benutzernameTextfeld;

    @FindBy(xpath = "//div[@class='mat-form-field-flex ng-tns-c39-1']")
    public WebElement passwortTextfeld;

    @FindBy(xpath = "//div[@class='mat-form-field-flex ng-tns-c39-2']")
    public WebElement passwortWiederholungTextfeld;

    @FindBy(xpath = "//span[@class='mat-checkbox-inner-container']")
    public WebElement nutzungsbedingungenCheckBox;

    @FindBy(xpath = "//button[@class='ng-star-inserted btn btn-default btn-fade-bg right btn-default__icon']")
    public WebElement jetzRegisterButton;

    //Meldungen
    @FindBy(xpath = "//h2[@class='headline headline__icon']")
    public WebElement registrierungsMeldung;

    @FindBy(xpath = "Der von Ihnen angegebene Benutzername wird bereits verwendet.")
    public WebElement verwendeterBenutzernameMeldung;

}