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
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToFloorsManagement() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", FloorsManagementPageID, browser, "Click on FloorsManagement Page Link");
        assertByPageName("Floors Management");
    }

    String RandomString = generateString();
    String FloorsManagementName = "FloorsManagement" + RandomString;

    @Test(priority = 2)
    public void addFloorsManagement() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", FloorsManagementPageID, browser, "Click on FloorsManagement Page Link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtFloorName']", FloorsManagementName, browser, "Fill Name");
        senKeys("cssselector", "input[id$='txtOrder']", RandomString, browser, "Fill Order");
        DDLByIndex("select[id$='ddlBranches']", 1, browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3)
    public void editFloorsManagement() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", FloorsManagementPageID, browser, "Click on FloorsManagement Page Link");
        senKeys("cssselector", "input[id$='txtName']", FloorsManagementName, browser, "Search By Name");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4)
    public void deleteFloorsManagement() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", FloorsManagementPageID, browser, "Click on FloorsManagement Page Link");
        senKeys("cssselector", "input[id$='txtName']", FloorsManagementName, browser, "Search By Name");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdFloorsItem']", browser, "Click on the CheckBox to delete");
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
