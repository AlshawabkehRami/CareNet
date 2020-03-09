package test.CareNetSettings.Insurance;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/23/2020 9:36 AM
 **/

public class ClaimsFileManager extends BasePage {
    WebDriver browser;
    @BeforeMethod
    public void setUp() {
        browser = theBrowser();
    }
    @Test
    public void navigateToClaimsFileManagerPage() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        insuranceLinknavigation(browser);
        click("id", ClaimsFileManagerPageID, browser, "Click on Claims File Manager   Page  link ");
        assertByPageName("Claims File Manager");
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
