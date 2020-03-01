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
public class MachineSetup extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl08_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToMachineSetup() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Setup Page Link");
        assertByPageName("Machine Setup");
    }

    String RandomString = generateString();
    String MachineSetupآName = "MachineSetupName" + RandomString;

    @Test(priority = 2)
    public void addMachineSetup() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Setup Page Link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtMachineSetupName']", MachineSetupآName, OpenDriver, "Fill Machine Setup Name");
        DDLByIndex("select[id$='ddlMachineType']", 1, OpenDriver);
        DDLByIndex("select[id$='ddlBranch']", 1, OpenDriver);
        DDLByIndex("select[id$='ddlMachineStatus']", 1, OpenDriver);
        Thread.sleep(2000);
        DDLByIndex("select[id$='ddlRefProvider']", 1, OpenDriver);
        click("cssselector", "input[id$='chbCanSend']", OpenDriver, "Check chbCanSend");
        click("cssselector", "input[id$='chbCanReceive']", OpenDriver, "Check chbCanReceive");
        click("cssselector", "input[id$='cbCheckStatus']", OpenDriver, "Check cbCheckStatus");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addMachineSetup")
    public void editMachineSetup() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Setup Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineSetupآName, OpenDriver, "Fill Name to search");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addMachineSetup")
    public void deleteMachineSetup() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Setup Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineSetupآName, OpenDriver, "Fill Name to search");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='grdhMachineSetupsItem']", OpenDriver, "Click on CheckBox to delete");
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
