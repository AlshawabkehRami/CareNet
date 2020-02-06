package test.CareNetSettings.QualityControl;

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
 * Created By R.Alshawabkeh 1/22/2020 2:42 PM
 **/

public class LotsNumbers extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl07_rptForms_ctl01_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test
    public void navigateToLotsNumbersPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToQualityControlLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver,"Click on Lots Numbers Page  link ");
        Wait = new WebDriverWait(OpenDriver, 20);
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_lblPageName"))).getText();
        String ExpectedResult = "Lots Numbers";
        Assert.assertEquals(ActualResult, ExpectedResult, "Lots Numbers Page not opened Properly");
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
