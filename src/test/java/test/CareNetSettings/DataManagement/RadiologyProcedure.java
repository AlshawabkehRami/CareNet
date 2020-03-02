package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/3/2019 5:03 PM
 **/
public class RadiologyProcedure extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToRadiologyProcedure() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", RadiologyProcedurePageID, browser, "Click on Radiology Procedure Link Page");
        assertByPageName("Radiology Procedures");
    }

    String RandomString = generateString();
    String RadiologyProcedureName = "Medical Test Name" + RandomString;

    @Test(priority = 2)
    public void addRadiologyProcedure() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", RadiologyProcedurePageID, browser, "Click on Radiology Procedure Link Page");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtMedicalTestName']", RadiologyProcedureName, browser, "Fill Medical Test Name");
        senKeys("cssselector", "input[id$='txtMedicalTestName2']", "Medical Test Name 2" + RandomString, browser, "Fill Medical Test Name2");
        senKeys("cssselector", "input[id$='txtAlias']", "Alias" + RandomString, browser, "Fill Alias");
        DDLByIndex("select[id$='ddlCategories']", 1, browser);
        senKeys("cssselector", "input[id$='txtCode']", "Code" + RandomString, browser, "Fill Code ");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlGender", "Female", browser);
        senKeys("cssselector", "textarea[id$='txtPreRequisites']", "Prerequisites" + RandomString, browser, "Fill Prerequisites");
        senKeys("cssselector", "input[id$='txtTestTime']", "12", browser, "Fill Test Time");
        senKeys("cssselector", "input[id$='txtStandardCode']", "Standard Code" + RandomString, browser, " Fill Standard Code");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addRadiologyProcedure")
    public void editRadiologyProcedure() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", RadiologyProcedurePageID, browser, "Click on Radiology Procedure Link Page");
        senKeys("cssselector", "input[id$='txtNameSearch']", RadiologyProcedureName, browser, "Fill search Name ");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addRadiologyProcedure")
    public void deleteRadiologyProcedure() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", RadiologyProcedurePageID, browser, "Click on Radiology Procedure Link Page");
        senKeys("cssselector", "input[id$='txtNameSearch']", RadiologyProcedureName, browser, "Fill search Name ");
        clickOnSearchButton(browser);
        click("cssselector", "input[id$='grdMedicalTestsItem']", browser, "Click on The Checkbox for delete");
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
