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
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToAssetTypes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", AssetTypesPageID, browser, "Click on AssetTypes Page Link");
        assertByPageName("Asset Types");
    }

    String RandomString = generateString();
    String AssetTypesName = "AssetTypesName" + RandomString;

    @Test(priority = 2)
    public void addAssetTypes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", AssetTypesPageID, browser, "Click on AssetTypes Page Link");
        Thread.sleep(1000);
        click("cssselector", "a[id$='ibtnAddItemType']", browser, "Click on Add Button");
        senKeys("cssselector", "input[id$='txtItemTypeName']", AssetTypesName, browser, "Fill The Asset Type Name");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addAssetTypes")
    public void editAssetTypes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", AssetTypesPageID, browser, "Click on AssetTypes Page Link");
        senKeys("cssselector", "input[id$='txtItemTypeNameSearch']", AssetTypesName, browser, "Fill The Asset Type Name");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addAssetTypes")
    public void deleteAssetTypes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", AssetTypesPageID, browser, "Click on AssetTypes Page Link");
        senKeys("cssselector", "input[id$='txtItemTypeNameSearch']", AssetTypesName, browser, "Fill The Asset Type Name");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='gvItemTypesItem']", browser, "Click on the checkBox for delete");
        click("cssselector","a[id$='ibtnDeleteItemType']", browser,"Click on Delete Button");
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
