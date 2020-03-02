package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/4/2019 9:05 AM
 **/


public class LookupItems extends BasePage {
    WebDriver browser;

    @BeforeMethod

    public void setUp() {
        browser=theBrowser();
    }

     @Test(priority = 1)
     public void navigateToLookupItemsPage() throws InterruptedException {
         navigateToUrl(browser);
         loginWithAdminUser(browser);
         navigateToDataManagmentLink(browser);
         click("id", LookupItemsPageID, browser, "Click on Lookup Items Page Link");
         assertByPageName("Lookup Items");

     }
    String RandomString = generateString();
    String LookupItemName = "Lookup Item Name" + RandomString;

    @Test(priority = 2)
    public void addLookupItems() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", LookupItemsPageID, browser, "Click on Lookup Items Page Link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtLookupItemName']", LookupItemName, browser, "Fill Lookup Item Name");
        senKeys("cssselector", "input[id$='txtLookupItemName2']", LookupItemName, browser, "Fill Lookup Item Name2");
        Thread.sleep(1000);
        click("cssselector", "input[id$='btnSaveAndClose']", browser, "Click on Save Button");
        assertOperationDoneSuccessfully();

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
