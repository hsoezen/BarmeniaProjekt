package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {

    public static void cookiesShadowRootElementClick(String path) {

        WebElement shadowElment = null;
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            shadowElment = (WebElement) js.executeScript("return " + ConfigReader.getProperty(path));
            shadowElment.click();

        } catch (Exception e) {
            System.out.println("CookiesShadowElement existiert nicht!");
        }
    }

    public static WebElement cookiesShadowRoot2(String path) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement shadowElment = (WebElement) js.executeScript("return " + ConfigReader.getProperty(path));

        return shadowElment;
    }


    public static void mitTryCatchBlock_Anklicken(WebElement element) {

        try {
            element.click();

        } catch (Exception e) {
            System.out.println("Element ist nicht anklickbar!");
        }

    }

    public static void screenShotsErzeugen(String screenShotName) throws IOException {

        String name = screenShotName;
        String date = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        String target = System.getProperty("user.dir") + "/target/screenshots/" + name + date + ".png";

        //TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);

        File finalDestination = new File(target);

        FileUtils.copyFile(source, finalDestination);
    }

    public static void partialScreenshotErzeugen(String screenshotName, WebElement elementName) throws IOException {

        String name = screenshotName;
        String date = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        String target = System.getProperty("user.dir") + "/target/screenshots/" + name + date + ".png";

        //TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = elementName.getScreenshotAs(OutputType.FILE);

        File finalDestination = new File(target);

        FileUtils.copyFile(source, finalDestination);
    }

    public static void scroolTo(WebElement elementName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", elementName);

    }

    public static void zurSeite(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    private static final String TASKLIST = "tasklist";
    private static final String KILL = "taskkill /F /IM ";

    public static boolean isProcessRunning(String serviceName) throws Exception {

        Process p = Runtime.getRuntime().exec(TASKLIST);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                p.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {

            System.out.println(line);
            if (line.contains(serviceName)) {

                return true;
            }
        }

        return false;

    }
    //ReusableMethoden für Thread Local Driver. Wir müssen threadLocalDriver als driver zuweisen.

    public static WebElement shadowCookies(WebDriver driver, String shadowElementPath) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement shadowCookies = (WebElement) js.executeScript("return " + ConfigReader.getProperty(shadowElementPath));

        return shadowCookies;

    }

    public static void getScreenshots(WebDriver driver, String screenShotName) throws IOException {
        String name = screenShotName;
        String datum = new SimpleDateFormat("hh.mm.ss.dd.MM.yyyy").format(new Date());
        String zielPath = System.getProperty("user.dir") + "/target/threadScreenshots/" + datum + "-"+name + ".jpg";

        File quelle = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File ziel = new File(zielPath);
        FileUtils.copyFile(quelle, ziel);

    }

    public static void getScreenshotsElement(WebElement element, String screenShotName) throws IOException {
        String name = screenShotName;
        String datum = new SimpleDateFormat("hh.mm.ss.dd.MM.yyyy").format(new Date());
        String zielPath = System.getProperty("user.dir") + "/target/threadScreenshots/" + datum + name + ".jpg";

        File quelle = element.getScreenshotAs(OutputType.FILE);
        File ziel = new File(zielPath);
        FileUtils.copyFile(quelle, ziel);
    }

    public static void waitExpilicit(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}


