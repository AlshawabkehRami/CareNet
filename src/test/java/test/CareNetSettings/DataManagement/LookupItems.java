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

     @Test(priority = 1)
     public void navigateToLookupItemsPage() throws InterruptedException {
         navigateToUrl(OpenDriver);
         loginWithAdminUser(OpenDriver);
         navigateToDataManagmentLink(OpenDriver);
         click("id", PageLinkLocator, OpenDriver, "Click on Lookup Items Page Link");
         assertByPageName("Lookup Items");

     }
    String RandomString = generateString();
    String LookupItemName = "Lookup Item Name" + RandomString;

    @Test(priority = 2)
    public void addLookupItems() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lookup Items Page Link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtLookupItemName']", LookupItemName, OpenDriver, "Fill Lookup Item Name");
        senKeys("cssselector", "input[id$='txtLookupItemName2']", LookupItemName, OpenDriver, "Fill Lookup Item Name2");
        Thread.sleep(1000);
        click("cssselector", "input[id$='btnSaveAndClose']", OpenDriver, "Click on Save Button");
        assertOperationDoneSuccessfully();

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
