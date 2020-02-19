package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/4/2019 8:58 AM
 **/
public class MedicalFormCodes extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl18_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToMedicalFormCodes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Form Codes Page link ");
        assertByPageName("Medical Form Codes");
    }

    String RandomString = generateString();
    String Name = "Name" + RandomString;


    @Test(priority = 2)
    public void addMedicalFormCodes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Form Codes Page link ");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtName']", Name, OpenDriver, "Fill The Name ");
        DDLByIndex("select[id$='ddlAttributeCodeCategory']", 1, OpenDriver);
        senKeys("cssselector", "textarea[id$='txtName2']", Name, OpenDriver, "Fill The Item Description ");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addMedicalFormCodes")
    public void editMedicalFormCodes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Form Codes Page link ");
        senKeys("cssselector", "input[id$='txtNameSearch']", Name, OpenDriver, "Fill Name for Search");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addMedicalFormCodes")
    public void deleteMedicalFormCodes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Form Codes Page link ");
        senKeys("cssselector", "input[id$='txtNameSearch']", Name, OpenDriver, "Fill Name for Search");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='grdhFormAttributeCodesItem']", OpenDriver, "Click on The CheckBox to Delete");
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
