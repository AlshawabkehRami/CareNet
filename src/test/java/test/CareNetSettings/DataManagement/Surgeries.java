package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/4/2019 8:43 AM
 **/
public class Surgeries extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl15_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToSurgeriesPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Surgeries page link");
        assertByPageName("Surgeries");
    }

    String RandomString = generateString();
    String SurgeriesName = "SurgeriesName" + RandomString;


    @Test(priority = 2)
    public void addSurgeries() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Surgeries page link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtSurgeryName']", SurgeriesName, OpenDriver, "Fill Surgery Name");
        DDLByIndex("select[id$='ddlSurgerySpecialty']", 1, OpenDriver);
        senKeys("cssselector", "input[id$='txtCode']", SurgeriesName, OpenDriver, "Fill Code");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addSurgeries")
    public void editSurgeries() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Surgeries page link");
        senKeys("cssselector", "input[id$='txtSearchSurgeryName']", SurgeriesName, OpenDriver, "Fill Surgery Name for search");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addSurgeries")
    public void deleteSurgeries() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Surgeries page link");
        senKeys("cssselector", "input[id$='txtSearchSurgeryName']", SurgeriesName, OpenDriver, "Fill Surgery Name for search");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='grdSurgeriesItem']", OpenDriver, "Click on the checkbox to delete");
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
