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
 * Created By R.Alshawabkeh 1/21/2020 4:18 PM
 **/
public class RoomsManagement extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToRoomsManagement() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomsManagementPageID, browser, "Click on Rooms Management Page Link");
        assertByPageName("Rooms Management");
    }

    String RandomString = generateString();
    String RoomsManagementName = "RoomsManagement" + RandomString;

    @Test(priority = 2)
    public void addRoomsManagement() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomsManagementPageID, browser, "Click on Rooms Management Page Link");
        click("cssselector", "a[id$='ibtnAddRoom']", browser, "Click on the Add button");
        senKeys("cssselector", "input[id$='txtRoomName']", RoomsManagementName, browser, "Fill Name");
        senKeys("cssselector", "input[id$='txtRoomName2']", RoomsManagementName, browser, "Fill Name 2");
        senKeys("cssselector", "input[id$='txtRoomCode']", RandomString, browser, "Fill Room Code ");
        DDLByIndex("select[id$='ddlRoomDepartment']", 1, browser);
        DDLByIndex("select[id$='ddlRoomType']", 1, browser);
        DDLByIndex("select[id$='ddlRoomCategory']", 1, browser);
        DDLByIndex("select[id$='ddlRoomGender']", 1, browser);
        senKeys("cssselector", "input[id$='txtRoomExtension']", "45454", browser, "Fill Extension ");
        senKeys("cssselector", "input[id$='txtAgeFrom']", "1", browser, "Fill Age From ");
        senKeys("cssselector", "input[id$='txtAgeTo']", "100", browser, "Fill Age To ");
        senKeys("cssselector", "input[id$='txtRoomCapacity']", "100", browser, "Fill Room Capacity ");
        DDLByIndex("select[id$='ddlFloor']", 1, browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addRoomsManagement")
    public void editRoomsManagement() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomsManagementPageID, browser, "Click on Rooms Management Page Link");
        senKeys("cssselector", "input[id$='txtRoomNameSearch']", RoomsManagementName, browser, "search By Name");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addRoomsManagement")
    public void deleteRoomsManagement() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomsManagementPageID, browser, "Click on Rooms Management Page Link");
        senKeys("cssselector", "input[id$='txtRoomNameSearch']", RoomsManagementName, browser, "search By Name");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='gvRoomsItem']", browser, "Click on CheckBox For Delete");
        click("cssselector", "a[id$='ibtnDeleteRoom']", browser, "Click on Delete Button");
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
