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
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_rptForms_ctl03_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToRoomsManagement() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Rooms Management Page Link");
        assertByPageName("Rooms Management");
    }

    String RandomString = generateString();
    String RoomsManagementName = "RoomsManagement" + RandomString;

    @Test(priority = 2)
    public void addRoomsManagement() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Rooms Management Page Link");
        click("cssselector", "a[id$='ibtnAddRoom']", OpenDriver, "Click on the Add button");
        senKeys("cssselector", "input[id$='txtRoomName']", RoomsManagementName, OpenDriver, "Fill Name");
        senKeys("cssselector", "input[id$='txtRoomName2']", RoomsManagementName, OpenDriver, "Fill Name 2");
        senKeys("cssselector", "input[id$='txtRoomCode']", RandomString, OpenDriver, "Fill Room Code ");
        DDLByIndex("select[id$='ddlRoomDepartment']", 1, OpenDriver);
        DDLByIndex("select[id$='ddlRoomType']", 1, OpenDriver);
        DDLByIndex("select[id$='ddlRoomCategory']", 1, OpenDriver);
        DDLByIndex("select[id$='ddlRoomGender']", 1, OpenDriver);
        senKeys("cssselector", "input[id$='txtRoomExtension']", "45454", OpenDriver, "Fill Extension ");
        senKeys("cssselector", "input[id$='txtAgeFrom']", "1", OpenDriver, "Fill Age From ");
        senKeys("cssselector", "input[id$='txtAgeTo']", "100", OpenDriver, "Fill Age To ");
        senKeys("cssselector", "input[id$='txtRoomCapacity']", "100", OpenDriver, "Fill Room Capacity ");
        DDLByIndex("select[id$='ddlFloor']", 1, OpenDriver);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addRoomsManagement")
    public void editRoomsManagement() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Rooms Management Page Link");
        senKeys("cssselector", "input[id$='txtRoomNameSearch']", RoomsManagementName, OpenDriver, "search By Name");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addRoomsManagement")
    public void deleteRoomsManagement() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Rooms Management Page Link");
        senKeys("cssselector", "input[id$='txtRoomNameSearch']", RoomsManagementName, OpenDriver, "search By Name");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='gvRoomsItem']", OpenDriver, "Click on CheckBox For Delete");
        click("cssselector", "a[id$='ibtnDeleteRoom']", OpenDriver, "Click on Delete Button");
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
