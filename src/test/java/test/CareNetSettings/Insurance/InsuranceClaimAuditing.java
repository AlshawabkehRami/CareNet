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
 * Created By R.Alshawabkeh 1/23/2020 9:25 AM
 **/

public class InsuranceClaimAuditing extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser = theBrowser();
    }

    @Test
    public void navigateToInsuranceClaimAuditing() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        insuranceLinknavigation(browser);
        click("id", InsuranceClaimAuditingPageID, browser, "Click on Insurance Claim Auditing   Page  link ");
        assertByPageName("Insurance Claim Auditing");
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
