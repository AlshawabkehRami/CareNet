package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/4/2019 9:03 AM
 **/


public class SpecialtyServices extends BasePage {
    WebDriver browser;

    @BeforeMethod

    public void setUp() {
        browser=theBrowser();
    }

    @Test
    public void navigateToSpecialtyServicesPage() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SpecialtyServicesPageID, browser,"Click on Specialty Services Page Link");

        Wait = new WebDriverWait(browser, 20);
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_ContentPlaceHolder1_lblSpecialtySearch"))).getText();
        String ExpectedResult = "Specialty Search";
        Assert.assertEquals(ActualResult, ExpectedResult, " Specialty Services Page not opened Properly");

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
