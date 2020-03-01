package test.CareNetSettings.Agreements;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/21/2020 4:45 PM
 **/
public class PayersNetworks extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl03_rptForms_ctl00_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToPayersNetworks() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToAgreements(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on  Payers Networks Page Link");
        assertByPageName("Payers Networks");
    }
    @Test(priority = 2)
    public void searchPayersNetworks() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToAgreements(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on  Payers Networks Page Link");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlCompanyTypeSearch", "All", OpenDriver);
        clickOnSearchButton(OpenDriver);
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
