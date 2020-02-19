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
 * Created By R.Alshawabkeh 12/4/2019 9:05 AM
 **/


public class LookupItems extends BasePage {

    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl22_lblfontFrm";

    @BeforeMethod

    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test
    public void navigateToLookupItemsPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver,"Click on Lookup Items Page Link");

        Wait = new WebDriverWait(OpenDriver, 20);
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_ContentPlaceHolder1_lblSearchArea"))).getText();
        String ExpectedResult = "Search";
        Assert.assertEquals(ActualResult, ExpectedResult, " Lookup Items  Page not opened Properly");

    }

    @AfterMethod
    public void tearDown(ITestResult result, Method method) {
        if (!result.isSuccess()) {
            screenShot(OpenDriver, result, method.getName());

        }
        OpenDriver.quit();
        Reporter.log("Closing The Browser");
    }

}
