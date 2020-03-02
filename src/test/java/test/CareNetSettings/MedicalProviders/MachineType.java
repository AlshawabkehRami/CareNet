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
    WebDriver browser;


    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToMachineType() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        medicalProvidersLinkNavigation(browser);
        click("id", MachineTypePageID, browser, "Click on Machine Type Page Link");
        assertByPageName("Machine Type");
    }

    String RandomString = generateString();
    String MachineTypeName = "MachineTypeName" + RandomString;

    @Test(priority = 2)
    public void addMachineType() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        medicalProvidersLinkNavigation(browser);
        click("id", MachineTypePageID, browser, "Click on Machine Type Page Link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtMachineTypeName']", MachineTypeName, browser, "Fill Machine Type Name");
        DDLByIndex("select[id$='ddlCommStandardType']", 1, browser);
        DDLByIndex("select[id$='ddlFunctionalTypeDetails']", 1, browser);
        senKeys("cssselector", "input[id$='txtOrderListTimeOut']", "1", browser, "Fill Order List Time Out");
        senKeys("cssselector", "input[id$='txtOrderListMaxNo']", "20", browser, "Fill Order List Max No");
        senKeys("cssselector", "textarea[id$='txtCommStanderdFormat']", "Communication Format", browser, "Fill Communication Format");
        click("cssselector", "input[id$='chbCheckStatus']", browser, "click on Check Status ");
       // senKeys("cssselector", "input[id$='txtBarcodeLength']", "1111", OpenDriver, "Enter Barcode Length");
        DDLByIndex("select[id$='ddlConnectionType']", 1, browser);
        DDLByIndex("select[id$='ddlBarcodeType']", 1, browser);
        senKeys("cssselector", "textarea[id$='txtNotes']", "Notes", browser, "Fill the Notes");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addMachineType")
    public void editMachineType() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        medicalProvidersLinkNavigation(browser);
        click("id", MachineTypePageID, browser, "Click on Machine Type Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineTypeName, browser, "Search by Name");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addMachineType")
    public void deleteMachineType() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        medicalProvidersLinkNavigation(browser);
        click("id", MachineTypePageID, browser, "Click on Machine Type Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineTypeName, browser, "Search by Name");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdhMachineTypesItem']", browser, "Click on CheckBox for Delete");
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
