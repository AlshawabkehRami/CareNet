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
 * Created By R.Alshawabkeh 1/22/2020 2:15 PM
 **/

public class ContactsManagement extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser = theBrowser();
    }

    @Test
    public void navigateToContactsManagementPage() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        communicationLinkNavigation(browser);
        click("id", ContactsManagementPageID, browser, "Click on Contacts Management  Page link ");
        assertByPageName("Contacts Management");
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
