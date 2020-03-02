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
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToSurgeriesPage() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SurgeriesPageID, browser, "Click on Surgeries page link");
        assertByPageName("Surgeries");
    }

    String RandomString = generateString();
    String SurgeriesName = "SurgeriesName" + RandomString;


    @Test(priority = 2)
    public void addSurgeries() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SurgeriesPageID, browser, "Click on Surgeries page link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtSurgeryName']", SurgeriesName, browser, "Fill Surgery Name");
        DDLByIndex("select[id$='ddlSurgerySpecialty']", 1, browser);
        senKeys("cssselector", "input[id$='txtCode']", SurgeriesName, browser, "Fill Code");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addSurgeries")
    public void editSurgeries() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SurgeriesPageID, browser, "Click on Surgeries page link");
        senKeys("cssselector", "input[id$='txtSearchSurgeryName']", SurgeriesName, browser, "Fill Surgery Name for search");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addSurgeries")
    public void deleteSurgeries() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SurgeriesPageID, browser, "Click on Surgeries page link");
        senKeys("cssselector", "input[id$='txtSearchSurgeryName']", SurgeriesName, browser, "Fill Surgery Name for search");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdSurgeriesItem']", browser, "Click on the checkbox to delete");
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
