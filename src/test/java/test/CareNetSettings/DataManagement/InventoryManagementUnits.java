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
public class InventoryManagementUnits extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl25_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToInventoryManagementUnits() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Navigate To Inventory Management Units Page");
        assertByPageName("Inventory Measurement Units");
    }

    String RandomString = generateString();
    String InventoryManagementUnitsName = "InventoryManagementUnits" + RandomString;

    @Test(priority = 2)
    public void addInventoryManagementUnits() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Navigate To Inventory Management Units Page");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtInventoryMeasurementUnitName']", InventoryManagementUnitsName, OpenDriver, "Fill InventoryManagementUnits Name ");
        senKeys("cssselector", "input[id$='txtInventoryMeasurementUnitName2']", InventoryManagementUnitsName, OpenDriver, "Fill InventoryManagementUnits Name ");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addInventoryManagementUnits")
    public void editInventoryManagementUnits() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Navigate To Inventory Management Units Page");
        senKeys("cssselector", "input[id$='txtName']", InventoryManagementUnitsName, OpenDriver, "Fill Name For Search");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addInventoryManagementUnits")
    public void deleteInventoryManagementUnits() throws InterruptedException {

        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Navigate To Inventory Management Units Page");
        senKeys("cssselector", "input[id$='txtName']", InventoryManagementUnitsName, OpenDriver, "Fill Name For Search");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='grdinventoryMeasurementUnitsItem']", OpenDriver, "click on the CheckBox for Delete");
        clickOnDeleteButton(OpenDriver);
        acceptTheWebPageAlert(OpenDriver);
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
