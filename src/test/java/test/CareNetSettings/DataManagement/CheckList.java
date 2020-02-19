package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/4/2019 9:01 AM
 **/

public class CheckList extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl19_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToCheckList() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on CheckList Page link ");
        assertByPageName("CheckLists");
    }

    String RandomString = generateString();
    String ChecklistName = "ChecklistName" + RandomString;


    @Test(priority = 2)
    public void addCheckLists() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on CheckList Page link ");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtChecklistName']", ChecklistName, OpenDriver, "Fill Checklist Name");
        DDLByIndex("select[id$='ddlSpecialty']", 1, OpenDriver);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addCheckLists")
    public void editCheckLists() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on CheckList Page link ");
        senKeys("cssselector", "input[id$='txtDoctorChecklistName']", ChecklistName, OpenDriver, "Fill Checklist Name for search ");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
    }

    @Test(priority = 4, dependsOnMethods = "addCheckLists")
    public void deleteCheckLists() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on CheckList Page link ");
        senKeys("cssselector", "input[id$='txtDoctorChecklistName']", ChecklistName, OpenDriver, "Fill Checklist Name for search ");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='grdCheckListItem']", OpenDriver, "Click on checkbox for Delete");
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
