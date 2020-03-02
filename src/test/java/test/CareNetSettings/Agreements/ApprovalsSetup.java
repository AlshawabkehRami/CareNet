package test.CareNetSettings.Agreements;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/21/2020 4:46 PM
 **/

public class ApprovalsSetup extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser = theBrowser();
    }

    @Test

    public void navigateToApprovalsSetup() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        agreementsLinknavigation(browser);
        click("id", ApprovalsSetupPageID, browser, "Click on Approvals Setup Page Link");
        assertByPageName("Approvals Setup");

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
