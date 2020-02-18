package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
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
    @Test(priority = 2, dependsOnMethods = "navigateToContainerTypes")
    public void addContainerTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Container Types Page Link");
        clickOnSearchButton(OpenDriver);
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='ContainerTypeName']", ContainerTypeName, OpenDriver, "Fill Container Type Name");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 3, dependsOnMethods = "addContainerTypes")
    public void editContainerTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Container Types Page Link");
        senKeys("cssselector", "input[id$='txtName']", ContainerTypeName, OpenDriver, "Fill Search Field With :: " + ContainerTypeName);
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 4, dependsOnMethods = "addContainerTypes")
    public void deleteContainerTypes() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Container Types Page Link");
        senKeys("cssselector", "input[id$='txtName']", ContainerTypeName, OpenDriver, "Fill Search Field With :: " + ContainerTypeName);
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='gvContainerTypesItem']", OpenDriver, "Click on the CheckBox for Delete");
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
