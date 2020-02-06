package test.CareNetSettings.Communication;

import Driver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/22/2020 12:59 PM
 **/

public class CommunicationSettings extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl05_rptForms_ctl02_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test
    public void navigateToCommunicationSettingsPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToCommunicationLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver,"Click on Communication Settings  Page link ");
        Wait = new WebDriverWait(OpenDriver, 20);
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_lblPageName"))).getText();
        String ExpectedResult = "Communication Settings";
        Assert.assertEquals(ActualResult, ExpectedResult, " Communication Settings  Page not opened Properly");
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
