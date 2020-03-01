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
public class FloorsManagement extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_rptForms_ctl04_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToFloorsManagement() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on FloorsManagement Page Link");
        assertByPageName("Floors Management");
    }

    String RandomString = generateString();
    String FloorsManagementName = "FloorsManagement" + RandomString;

    @Test(priority = 2)
    public void addFloorsManagement() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on FloorsManagement Page Link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtFloorName']", FloorsManagementName, OpenDriver, "Fill Name");
        senKeys("cssselector", "input[id$='txtOrder']", RandomString, OpenDriver, "Fill Order");
        DDLByIndex("select[id$='ddlBranches']", 1, OpenDriver);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3)
    public void editFloorsManagement() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on FloorsManagement Page Link");
        senKeys("cssselector", "input[id$='txtName']", FloorsManagementName, OpenDriver, "Search By Name");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4)
    public void deleteFloorsManagement() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on FloorsManagement Page Link");
        senKeys("cssselector", "input[id$='txtName']", FloorsManagementName, OpenDriver, "Search By Name");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='grdFloorsItem']", OpenDriver, "Click on the CheckBox to delete");
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
