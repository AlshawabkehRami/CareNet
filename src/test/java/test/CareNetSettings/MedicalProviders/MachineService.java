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

public class MachineService extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToMachineService() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToMedicalProvidersLink(browser);
        click("id", MachineServicePageID, browser, "Click on Machine Service Page Link");
        assertByPageName("Machine Service");
    }

    String RandomString = generateString();
    String MachineServiceName = "MachineService" + RandomString;

    @Test(priority = 2)
    public void addMachineService() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToMedicalProvidersLink(browser);
        click("id", MachineServicePageID, browser, "Click on Machine Service Page Link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtCode']", RandomString, browser, "Fill The Code ");
        senKeys("cssselector", "input[id$='txtName']", MachineServiceName, browser, "Fill The Name");
        DDLByIndex("select[id$='ddlServiceTypeEntry']", 1, browser);
        Thread.sleep(2000);
        senKeys("cssselector", "input[id$='txtStandardCode']", MachineServiceName, browser, "Fill the txtStandardCode");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addMachineService")
    public void editMachineService() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToMedicalProvidersLink(browser);
        click("id", MachineServicePageID, browser, "Click on Machine Service Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineServiceName, browser, "FilltxtNameSearch");
        click("cssselector", "input[id$='btnSerach']", browser, "Click on The Search Button");
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4, dependsOnMethods = "addMachineService")
    public void deleteMachineService() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        NavigateToMedicalProvidersLink(browser);
        click("id", MachineServicePageID, browser, "Click on Machine Service Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineServiceName, browser, "FilltxtNameSearch");
        click("cssselector", "input[id$='btnSerach']", browser, "Click on The Search Button");
        click("cssselector", "input[name$='gvServicesItem']", browser, "Click on the CheckBox to delete");
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
