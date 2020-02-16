package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created By R.Alshawabkeh 12/3/2019 4:36 PM
 **/
public class LabSampleTypes extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl09_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToLabSampleTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Sample Types link Page");
        assertByPageName("Lab Sample Types");
    }

    String RandomString = generateString();
    String SampleTypesName = "SampleTypesName" + RandomString;

    @Test(priority = 2)
    public void addLabSampleTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Sample Types link Page");
        click("cssselector", "a[id*='ibtnAdd']", OpenDriver, "Click on Add Button");
        senKeys("cssselector", "input[id$='txtName']", SampleTypesName, OpenDriver, "Fill Name");
        senKeys("cssselector", "input[id$='txtValidityHours']", "15", OpenDriver, "Fill Validity Hours");
        senKeys("cssselector", "input[id$='txtMinimumTemperature']", "1", OpenDriver, "Fill Min Temperature");
        senKeys("cssselector", "input[id$='txtMaximumTemperature']", "50", OpenDriver, "Fill Max Temperature");
        senKeys("cssselector", "textarea[id$='txtInstructions']", "Instructions" + RandomString, OpenDriver, "Fill Instructions");
        click("cssselector", "input[id$='btnSave']", OpenDriver, "Click on Save button");
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3, dependsOnMethods = "addLabSampleTypes")
    public void editLabSampleTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Sample Types link Page");
        senKeys("cssselector", "input[id$='txtSampleTypeName']", SampleTypesName, OpenDriver, "Searching for Sample Types Name");
        click("cssselector", "input[id$='btnSearch']", OpenDriver, "Click on The Search Button");
        Thread.sleep(7000);
        clickOnTheRowTable(OpenDriver);
        click("cssselector", "input[id$='btnUpdate']", OpenDriver, "Click on The Update Button");
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4, dependsOnMethods = "addLabSampleTypes")
    public void deleteLabSampleTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Sample Types link Page");
        senKeys("cssselector", "input[id$='txtSampleTypeName']", SampleTypesName, OpenDriver, "Searching for Sample Types Name");
        click("cssselector", "input[id$='btnSearch']", OpenDriver, "Click on The Search Button");
        Thread.sleep(5000);
        click("cssselector", "input[name*='gvSampleTypesItem']", OpenDriver, "Click on the CheckBox to delete");
        click("cssselector", "a[id$='ibtnDelete']", OpenDriver, "Click on Delete Button");
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
