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
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser = theBrowser();
    }

    @Test(priority = 1)
    public void navigateToPayersNetworks() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        agreementsLinknavigation(browser);
        click("id", PayersNetworksPageID, browser, "Click on  Payers Networks Page Link");
        assertByPageName("Payers Networks");
    }

    @Test(priority = 2)
    public void searchPayersNetworks() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        agreementsLinknavigation(browser);
        click("id", PayersNetworksPageID, browser, "Click on  Payers Networks Page Link");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlCompanyTypeSearch", "All", browser);
        clickOnSearchButton(browser);
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
