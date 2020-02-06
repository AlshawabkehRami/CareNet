package test.CareNetSettings.MedicalProviders;

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
 * Created By R.Alshawabkeh 1/20/2020 5:50 PM
 **/

public class NonNetworkProviders extends BasePage {

    WebDriver driver;
    WebDriver OpenDriver;

    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl01_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test
    public void navigateToNonNetworkProvidersPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver,"Click on Non-Network Providers Page Link");
        Wait = new WebDriverWait(OpenDriver, 20);
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_lblPageName"))).getText();
        String ExpectedResult = "Non-Network Providers";
        Assert.assertEquals(ActualResult, ExpectedResult, "Non-Network Providers  Page not opened Properly");
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
