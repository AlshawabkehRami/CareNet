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

    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl09_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToMachineService() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Service Page Link");
        assertByPageName("Machine Service");
    }

    String RandomString = generateString();
    String MachineServiceName = "MachineService" + RandomString;

    @Test(priority = 2)
    public void addMachineService() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Service Page Link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtCode']", RandomString, OpenDriver, "Fill The Code ");
        senKeys("cssselector", "input[id$='txtName']", MachineServiceName, OpenDriver, "Fill The Name");
        DDLByIndex("select[id$='ddlServiceTypeEntry']", 1, OpenDriver);
        Thread.sleep(2000);
        senKeys("cssselector", "input[id$='txtStandardCode']", MachineServiceName, OpenDriver, "Fill the txtStandardCode");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addMachineService")
    public void editMachineService() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Service Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineServiceName, OpenDriver, "FilltxtNameSearch");
        click("cssselector", "input[id$='btnSerach']", OpenDriver, "Click on The Search Button");
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4, dependsOnMethods = "addMachineService")
    public void deleteMachineService() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Machine Service Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", MachineServiceName, OpenDriver, "FilltxtNameSearch");
        click("cssselector", "input[id$='btnSerach']", OpenDriver, "Click on The Search Button");
        click("cssselector", "input[name$='gvServicesItem']", OpenDriver, "Click on the CheckBox to delete");
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
