package test.CareNetSettings.QualityControl;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/22/2020 2:45 PM
 **/

public class DefinalizationConfirmation extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser = theBrowser();
    }

    @Test
    public void navigateToDefinalizationConfirmationPage() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        qualityControlLinkNavigation(browser);
        click("id", DefinalizationConfirmationPageID, browser, "Click on Definalization Confirmation Page  link ");
        assertByPageName("Definalization Confirmation");
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
