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
 * Created By R.Alshawabkeh 1/23/2020 9:18 AM
 **/

public class Authorizations extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser = driverType(driver, "chrome");
    }

    @Test
    public void navigateToAuthorizations() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        insuranceLinknavigation(browser);
        click("id", AuthorizationsPageID, browser, "Click on Authorizations   Page  link ");
        assertByPageName("Authorizations");
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
