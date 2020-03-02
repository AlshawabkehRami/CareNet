package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;
/**
 * Created By R.Alshawabkeh 12/4/2019 9:15 AM
 **/
public class ImportMedicines extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test
    public void navigateToImportMedicines() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", ImportMedicinesPageID, browser, "Click on Import Medicines Page");
        assertByPageName("Import Medicines");
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
