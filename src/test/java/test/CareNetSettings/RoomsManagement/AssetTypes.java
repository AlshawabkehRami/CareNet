package test.CareNetSettings.RoomsManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/21/2020 4:17 PM
 **/
public class AssetTypes extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_rptForms_ctl00_lnkForms";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToAssetTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on AssetTypes Page Link");
        assertByPageName("Asset Types");
    }

    String RandomString = generateString();
    String AssetTypesName = "AssetTypesName" + RandomString;

    @Test(priority = 2)
    public void addAssetTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on AssetTypes Page Link");
        Thread.sleep(1000);
        click("cssselector", "a[id$='ibtnAddItemType']", OpenDriver, "Click on Add Button");
        senKeys("cssselector", "input[id$='txtItemTypeName']", AssetTypesName, OpenDriver, "Fill The Asset Type Name");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addAssetTypes")
    public void editAssetTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on AssetTypes Page Link");
        senKeys("cssselector", "input[id$='txtItemTypeNameSearch']", AssetTypesName, OpenDriver, "Fill The Asset Type Name");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addAssetTypes")
    public void deleteAssetTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on AssetTypes Page Link");
        senKeys("cssselector", "input[id$='txtItemTypeNameSearch']", AssetTypesName, OpenDriver, "Fill The Asset Type Name");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='gvItemTypesItem']", OpenDriver, "Click on the checkBox for delete");
        click("cssselector","a[id$='ibtnDeleteItemType']",OpenDriver,"Click on Delete Button");
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
