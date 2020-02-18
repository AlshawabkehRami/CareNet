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
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl13_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToRadiologyProcedure() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Radiology Procedure Link Page");
        assertByPageName("Radiology Procedures");
    }

    String RandomString = generateString();
    String RadiologyProcedureName = "Medical Test Name" + RandomString;

    @Test(priority = 2)
    public void addRadiologyProcedure() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Radiology Procedure Link Page");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtMedicalTestName']", RadiologyProcedureName, OpenDriver, "Fill Medical Test Name");
        senKeys("cssselector", "input[id$='txtMedicalTestName2']", "Medical Test Name 2" + RandomString, OpenDriver, "Fill Medical Test Name2");
        senKeys("cssselector", "input[id$='txtAlias']", "Alias" + RandomString, OpenDriver, "Fill Alias");
        DDLByIndex("select[id$='ddlCategories']", 1, OpenDriver);
        senKeys("cssselector", "input[id$='txtCode']", "Code" + RandomString, OpenDriver, "Fill Code ");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlGender", "Female", OpenDriver);
        senKeys("cssselector", "textarea[id$='txtPreRequisites']", "Prerequisites" + RandomString, OpenDriver, "Fill Prerequisites");
        senKeys("cssselector", "input[id$='txtTestTime']", "12", OpenDriver, "Fill Test Time");
        senKeys("cssselector", "input[id$='txtStandardCode']", "Standard Code" + RandomString, OpenDriver, " Fill Standard Code");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addRadiologyProcedure")
    public void editRadiologyProcedure() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Radiology Procedure Link Page");
        senKeys("cssselector", "input[id$='txtNameSearch']", RadiologyProcedureName, OpenDriver, "Fill search Name ");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addRadiologyProcedure")
    public void deleteRadiologyProcedure() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Radiology Procedure Link Page");
        senKeys("cssselector", "input[id$='txtNameSearch']", RadiologyProcedureName, OpenDriver, "Fill search Name ");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[id$='grdMedicalTestsItem']", OpenDriver, "Click on The Checkbox for delete");
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
