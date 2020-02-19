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

    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl21_lblfontFrm";

    @BeforeMethod

    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test
    public void navigateToSpecialtyServicesPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver,"Click on Specialty Services Page Link");

        Wait = new WebDriverWait(OpenDriver, 20);
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_ContentPlaceHolder1_lblSpecialtySearch"))).getText();
        String ExpectedResult = "Specialty Search";
        Assert.assertEquals(ActualResult, ExpectedResult, " Specialty Services Page not opened Properly");

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
