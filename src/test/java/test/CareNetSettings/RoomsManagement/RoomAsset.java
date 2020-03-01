package test.CareNetSettings.RoomsManagement;

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
 * Created By R.Alshawabkeh 1/21/2020 4:17 PM
 **/

public class RoomAsset extends BasePage {

    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_rptForms_ctl01_lblfontFrm";


    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToRoomAsset() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Room Asset Page Link");
        assertByPageName("Room Asset");
    }

    String RandomString = generateString();
    String RoomAssetName = "RoomAssetName" + RandomString;

    @Test(priority = 2)
    public void addRoomAsset() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Room Asset Page Link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtlblInventoryItemCode']", RandomString, OpenDriver, "Fill  Code");
        senKeys("cssselector", "input[id$='txtNameDetails']", RoomAssetName, OpenDriver, "Fill Name");
        senKeys("cssselector", "input[id$='txtName2Details']", RoomAssetName, OpenDriver, "Fill Name 2");
        DDLByIndex("select[id$='ddlItemType']", 1, OpenDriver);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addRoomAsset")
    public void editRoomAsset() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Room Asset Page Link");
        senKeys("cssselector", "input[id$='txtName']", RoomAssetName, OpenDriver, "Search By Name");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4, dependsOnMethods = "addRoomAsset")
    public void deleteRoomAsset() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Room Asset Page Link");
        senKeys("cssselector", "input[id$='txtName']", RoomAssetName, OpenDriver, "Search By Name");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='grdInventoryItemsItem']", OpenDriver, "Click on The CheckBox to delete");
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
