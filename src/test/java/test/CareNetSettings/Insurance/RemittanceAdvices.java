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
 * Created By R.Alshawabkeh 1/22/2020 3:01 PM
 **/

public class RemittanceAdvices extends BasePage {

    WebDriver browser;


    @BeforeMethod
    public void setUp() {
        browser = theBrowser();
    }

    @Test
    public void navigateToRemittanceAdvices() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        insuranceLinknavigation(browser);
        click("id", RemittanceAdvicesPageID, browser, "Click on RemittanceAdvices Page  link ");
        assertByPageName("RemittanceAdvices");
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
