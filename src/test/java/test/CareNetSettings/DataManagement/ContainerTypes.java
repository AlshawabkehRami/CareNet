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

/**
 * Created By R.Alshawabkeh 12/3/2019 4:39 PM
 **/
public class ContainerTypes extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl10_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToContainerTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Container Types Page Link");
        assertByPageName("Container Types");

    }

    String RandomString = generateString();
    String ContainerTypeName = "Container Type Name" + RandomString;

    @Test(priority = 2,dependsOnMethods = "navigateToContainerTypes")
    public void addContainerTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Container Types Page Link");
        click("cssselector", "input[id$='btnSearch']", OpenDriver, "Click on Search Button");
        click("cssselector", "a[id$='ibtnAdd']", OpenDriver, "Click on Add Button");
        senKeys("cssselector", "input[id$='ContainerTypeName']", ContainerTypeName, OpenDriver, "Fill Container Type Name");
        click("cssselector", "input[id$='btnSave']", OpenDriver, "click on Save Button");
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3,dependsOnMethods = "addContainerTypes")
    public void editContainerTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Container Types Page Link");
        senKeys("cssselector", "input[id$='txtName']", ContainerTypeName, OpenDriver, "Fill Search Field With :: " + ContainerTypeName);
        click("cssselector", "input[id$='btnSearch']", OpenDriver, "Click on Search Button");
        clickOnTheRowTable(OpenDriver);
        click("cssselector", "input[id$='btnSave']", OpenDriver, "click on Save Button");
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4,dependsOnMethods = "addContainerTypes")
    public void deleteContainerTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Container Types Page Link");
        senKeys("cssselector", "input[id$='txtName']", ContainerTypeName, OpenDriver, "Fill Search Field With :: " + ContainerTypeName);
        click("cssselector", "input[id$='btnSearch']", OpenDriver, "Click on Search Button");
        click("cssselector", "input[name$='gvContainerTypesItem']", OpenDriver, "Click on the CheckBox for Delete");
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
