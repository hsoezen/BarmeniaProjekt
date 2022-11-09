package utilities;


import io.cucumber.java.bs.I;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

public class Hooks {

    @BeforeSuite
    public void setUp(){

    }
    @AfterSuite
    public void tearDown() throws IOException {
        Driver.getDriver().close();
    }
}
