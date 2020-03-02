package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/4/2019 9:01 AM
 **/

public class CheckList extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {

        browser=theBrowser();

    }

    @Test(priority = 1)
    public void navigateToCheckList() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", CheckListPageID, browser, "Click on CheckList Page link ");
        assertByPageName("CheckLists");
    }

    String RandomString = generateString();
    String ChecklistName = "ChecklistName" + RandomString;


    @Test(priority = 2)
    public void addCheckLists() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", CheckListPageID, browser, "Click on CheckList Page link ");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtChecklistName']", ChecklistName, browser, "Fill Checklist Name");
        DDLByIndex("select[id$='ddlSpecialty']", 1, browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addCheckLists")
    public void editCheckLists() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", CheckListPageID, browser, "Click on CheckList Page link ");
        senKeys("cssselector", "input[id$='txtDoctorChecklistName']", ChecklistName, browser, "Fill Checklist Name for search ");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
    }

    @Test(priority = 4, dependsOnMethods = "addCheckLists")
    public void deleteCheckLists() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", CheckListPageID, browser, "Click on CheckList Page link ");
        senKeys("cssselector", "input[id$='txtDoctorChecklistName']", ChecklistName, browser, "Fill Checklist Name for search ");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdCheckListItem']", browser, "Click on checkbox for Delete");
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
