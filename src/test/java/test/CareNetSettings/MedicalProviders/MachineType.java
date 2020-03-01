package test.CareNetSettings.MedicalProviders;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/20/2020 6:11 PM
 **/
public class MachineType extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl07_lblfontFrm";


    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToMachineType() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Type Page Link");
        assertByPageName("Machine Type");
    }

    String RandomString = generateString();
    String MachineTypeName = "MachineTypeName" + RandomString;

    @Test(priority = 2)
    public void addMachineType() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Type Page Link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtMachineTypeName']", MachineTypeName, OpenDriver, "Fill Machine Type Name");
        DDLByIndex("select[id$='ddlCommStandardType']", 1, OpenDriver);
        DDLByIndex("select[id$='ddlFunctionalTypeDetails']", 1, OpenDriver);
        senKeys("cssselector", "input[id$='txtOrderListTimeOut']", "1", OpenDriver, "Fill Order List Time Out");
        senKeys("cssselector", "input[id$='txtOrderListMaxNo']", "20", OpenDriver, "Fill Order List Max No");
        senKeys("cssselector", "textarea[id$='txtCommStanderdFormat']", "Communication Format", OpenDriver, "Fill Communication Format");
        click("cssselector", "input[id$='chbCheckStatus']", OpenDriver, "click on Check Status ");
       // senKeys("cssselector", "input[id$='txtBarcodeLength']", "1111", OpenDriver, "Enter Barcode Length");
        DDLByIndex("select[id$='ddlConnectionType']", 1, OpenDriver);
        DDLByIndex("select[id$='ddlBarcodeType']", 1, OpenDriver);
        senKeys("cssselector", "textarea[id$='txtNotes']", "Notes", OpenDriver, "Fill the Notes");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addMachineType")
    public void editMachineType() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Type Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineTypeName, OpenDriver, "Search by Name");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addMachineType")
    public void deleteMachineType() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Type Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineTypeName, OpenDriver, "Search by Name");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='grdhMachineTypesItem']", OpenDriver, "Click on CheckBox for Delete");
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
