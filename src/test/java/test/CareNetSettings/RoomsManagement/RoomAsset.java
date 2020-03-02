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

public class RoomAsset extends BasePage {
    WebDriver browser;


    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToRoomAsset() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomAssetPageID, browser, "Click on Room Asset Page Link");
        assertByPageName("Room Asset");
    }

    String RandomString = generateString();
    String RoomAssetName = "RoomAssetName" + RandomString;

    @Test(priority = 2)
    public void addRoomAsset() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomAssetPageID, browser, "Click on Room Asset Page Link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtlblInventoryItemCode']", RandomString, browser, "Fill  Code");
        senKeys("cssselector", "input[id$='txtNameDetails']", RoomAssetName, browser, "Fill Name");
        senKeys("cssselector", "input[id$='txtName2Details']", RoomAssetName, browser, "Fill Name 2");
        DDLByIndex("select[id$='ddlItemType']", 1, browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addRoomAsset")
    public void editRoomAsset() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomAssetPageID, browser, "Click on Room Asset Page Link");
        senKeys("cssselector", "input[id$='txtName']", RoomAssetName, browser, "Search By Name");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4, dependsOnMethods = "addRoomAsset")
    public void deleteRoomAsset() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomAssetPageID, browser, "Click on Room Asset Page Link");
        senKeys("cssselector", "input[id$='txtName']", RoomAssetName, browser, "Search By Name");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdInventoryItemsItem']", browser, "Click on The CheckBox to delete");
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
