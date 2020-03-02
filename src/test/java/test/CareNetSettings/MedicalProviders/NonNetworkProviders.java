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
 * Created By R.Alshawabkeh 1/20/2020 5:50 PM
 **/

public class NonNetworkProviders extends BasePage {

    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test
    public void navigateToNonNetworkProviders() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        medicalProvidersLinkNavigation(browser);
        click("id", NonNetworkProvidersPageID, browser, "Click on Non-Network Providers Page Link");
        assertByPageName("Non-Network Providers");
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
