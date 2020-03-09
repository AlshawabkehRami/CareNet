package test.CareNetSettings.QualityControl;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
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
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser = theBrowser();
    }

    @Test(priority = 1)
    public void navigateToLotsNumbers() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        qualityControlLinkNavigation(browser);
        click("id", LotsNumbersPageID, browser, "Click on Lots Numbers Page  link ");
        assertByPageName("Lots Numbers");
    }

    String RandomString = generateString();
    String LotsNumbersName = "LotsNumbersName" + RandomString;

    @Test(priority = 2)
    public void addLotsNumbers() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        qualityControlLinkNavigation(browser);
        click("id", LotsNumbersPageID, browser, "Click on Lots Numbers Page  link ");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtLotsNumbers']", LotsNumbersName, browser, "Fill lots Numbers");
        DDLByIndex("select[id$='ddlQcRangeType']", 1, browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 3, dependsOnMethods = "addLotsNumbers")
    public void editLotsNumbers() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        qualityControlLinkNavigation(browser);
        click("id", LotsNumbersPageID, browser, "Click on Lots Numbers Page  link ");
        senKeys("cssselector", "input[id$='txtLotsNumberSearch']", LotsNumbersName, browser, "Search By LotsNumbersName");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addLotsNumbers")
    public void deleteLotsNumbers() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        qualityControlLinkNavigation(browser);
        click("id", LotsNumbersPageID, browser, "Click on Lots Numbers Page  link ");
        senKeys("cssselector", "input[id$='txtLotsNumberSearch']", LotsNumbersName, browser, "Search By LotsNumbersName");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdLotsNumberItem']", browser, "Click on the checkbox to delete");
        clickOnDeleteButton(browser);
        acceptTheWebPageAlert(browser);
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
