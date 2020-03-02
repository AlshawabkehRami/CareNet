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
 * Created By R.Alshawabkeh 1/21/2020 4:46 PM
 **/
public class PriceLists extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl03_rptForms_ctl01_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test
    public void navigateToPriceLists() throws InterruptedException {
        URLnavigation(OpenDriver);
        adminLogin(OpenDriver);
        agreementsLinknavigation(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on  Price Lists Page Link");
        assertByPageName("Price Lists");


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
