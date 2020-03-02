package test.CareNetSettings.MedicalProviders;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/20/2020 6:10 PM
 **/

public class ProviderStaff extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser = theBrowser();
    }

    @Test
    public void navigateToProviderStaff() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToMedicalProvidersLink(browser);
        click("id", ProviderStaffPageID, browser, "Click on ProviderStaff Page Link");
        assertByPageName("Provider Staff");
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
