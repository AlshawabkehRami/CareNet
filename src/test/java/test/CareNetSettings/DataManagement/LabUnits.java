package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/3/2019 5:00 PM
 **/

public class LabUnits extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl11_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test
    public void navigateToLabUnits() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Units Link Page ");
        assertByPageName("Lab Units");
    }

    String RandomString = generateString();
    String LabUnitsName = "LabUnits" + RandomString;

    @Test(priority = 2)
    public void addLabUnits() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Units Link Page ");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[name$='UnitName']", LabUnitsName, OpenDriver, "Fill Conventional Unit");
        senKeys("cssselector", "input[name$='txtSIUnitName']", "SI Unit" + RandomString, OpenDriver, "Fill SI Unit");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 3, dependsOnMethods = "addLabUnits")
    public void editLabUnits() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Units Link Page ");
        senKeys("cssselector", "input[id$='txtNameSearch']", LabUnitsName, OpenDriver, "Fill Name Search");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4, dependsOnMethods = "addLabUnits")
    public void deleteLabUnits() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Units Link Page ");
        senKeys("cssselector", "input[id$='txtNameSearch']", LabUnitsName, OpenDriver, "Fill Name Search");
        clickOnSearchButton(OpenDriver);
        Thread.sleep(3000);
        click("cssselector", "input[name*='grdMeasurementUnitsItem']", OpenDriver, "Click on The checkBox To Delete");
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
