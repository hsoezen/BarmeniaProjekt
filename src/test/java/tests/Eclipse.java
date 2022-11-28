package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class Eclipse {
    @Test
    public void eclipse1(){
        System.out.println("Hallo");
        Driver.getDriver().get("https://www.barmenia.de");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement shadowroot = (WebElement) js.executeScript("return document.querySelector(\"#usercentrics-root\").shadowRoot.querySelector(\"#uc-center-container > div.sc-jJoQJp.dTzACB > div > div.sc-bBHxTw.hgPqkm > div > button.sc-gsDKAQ.bSyuWe\")");
        shadowroot.click();
        Driver.getDriver().findElement(By.xpath("//a[contains(text(),'Kundenportal ')]")).click();
        Driver.closeDriver();
    }
}
