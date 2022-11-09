package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ReusableMethods {

    public WebElement shadowRoot(String path){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement shadowElment = (WebElement) js.executeScript("return "+ConfigReader.getProperty(path));
        return shadowElment;
    }
}
