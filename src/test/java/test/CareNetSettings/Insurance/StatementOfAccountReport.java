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
 * Created By R.Alshawabkeh 1/23/2020 9:45 AM
 **/

public class StatementOfAccountReport extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser = driverType(driver, "chrome");
    }

    @Test
    public void navigateToStatementOfAccountReport() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        insuranceLinknavigation(browser);
        click("id", StatementOfAccountReportPageID, browser, "Click on Statement Of Account Report   Page  link ");
        assertByPageName("Statement Of Account Report");
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
