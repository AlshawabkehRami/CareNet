package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/4/2019 9:12 AM
 **/
public class InventoryMeasurementUnits extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToInventoryMeasurementUnits() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", InventoryManagementUnitsPageID, browser, "Navigate To Inventory Management Units Page");
        assertByPageName("Inventory Measurement Units");
    }

    String RandomString = generateString();
    String InventoryManagementUnitsName = "InventoryManagementUnits" + RandomString;

    @Test(priority = 2)
    public void addInventoryManagementUnits() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", InventoryManagementUnitsPageID, browser, "Navigate To Inventory Management Units Page");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtInventoryMeasurementUnitName']", InventoryManagementUnitsName, browser, "Fill InventoryManagementUnits Name ");
        senKeys("cssselector", "input[id$='txtInventoryMeasurementUnitName2']", InventoryManagementUnitsName, browser, "Fill InventoryManagementUnits Name ");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addInventoryManagementUnits")
    public void editInventoryManagementUnits() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", InventoryManagementUnitsPageID, browser, "Navigate To Inventory Management Units Page");
        senKeys("cssselector", "input[id$='txtName']", InventoryManagementUnitsName, browser, "Fill Name For Search");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addInventoryManagementUnits")
    public void deleteInventoryManagementUnits() throws InterruptedException {

        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", InventoryManagementUnitsPageID, browser, "Navigate To Inventory Management Units Page");
        senKeys("cssselector", "input[id$='txtName']", InventoryManagementUnitsName, browser, "Fill Name For Search");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdinventoryMeasurementUnitsItem']", browser, "click on the CheckBox for Delete");
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
