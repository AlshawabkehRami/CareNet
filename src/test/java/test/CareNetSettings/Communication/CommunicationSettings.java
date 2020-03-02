package test.CareNetSettings.Communication;

import Driver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/22/2020 12:59 PM
 **/

public class CommunicationSettings extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {

        browser = theBrowser();
    }

    @Test
    public void navigateToCommunicationSettingsPage() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        communicationLinkNavigation(browser);
        click("id", CommunicationSettingsPageID, browser, "Click on Communication Settings  Page link ");
        assertByPageName("Communication Settings");
    }

    @AfterMethod
    public void tearDown(ITestResult result, Method method) {
        if (!result.isSuccess()) {
            screenShot(browser, result, method.getName());
        }
        browser.quit();
        Reporter.log("Closing The Browser");
    }
}
