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
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToMachineSetup() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        medicalProvidersLinkNavigation(browser);
        click("id", MachineSetupPageID, browser, "Click on Machine Setup Page Link");
        assertByPageName("Machine Setup");
    }

    String RandomString = generateString();
    String MachineSetupName = "MachineSetupName" + RandomString;

    @Test(priority = 2)
    public void addMachineSetup() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        medicalProvidersLinkNavigation(browser);
        click("id", MachineSetupPageID, browser, "Click on Machine Setup Page Link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtMachineSetupName']", MachineSetupName, browser, "Fill Machine Setup Name");
        DDLByIndex("select[id$='ddlMachineType']", 1, browser);
        DDLByIndex("select[id$='ddlBranch']", 1, browser);
        DDLByIndex("select[id$='ddlMachineStatus']", 1, browser);
        Thread.sleep(2000);
        DDLByIndex("select[id$='ddlRefProvider']", 1, browser);
        click("cssselector", "input[id$='chbCanSend']", browser, "Check chbCanSend");
        click("cssselector", "input[id$='chbCanReceive']", browser, "Check chbCanReceive");
        click("cssselector", "input[id$='cbCheckStatus']", browser, "Check cbCheckStatus");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addMachineSetup")
    public void editMachineSetup() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        medicalProvidersLinkNavigation(browser);
        click("id", MachineSetupPageID, browser, "Click on Machine Setup Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineSetupName, browser, "Fill Name to search");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addMachineSetup")
    public void deleteMachineSetup() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        medicalProvidersLinkNavigation(browser);
        click("id", MachineSetupPageID, browser, "Click on Machine Setup Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineSetupName, browser, "Fill Name to search");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdhMachineSetupsItem']", browser, "Click on CheckBox to delete");
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
