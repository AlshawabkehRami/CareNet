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
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test
    public void navigateToLabUnits() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", LabUnitsPageID, browser, "Click on Lab Units Link Page ");
        assertByPageName("Lab Units");
    }

    String RandomString = generateString();
    String LabUnitsName = "LabUnits" + RandomString;

    @Test(priority = 2)
    public void addLabUnits() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", LabUnitsPageID, browser, "Click on Lab Units Link Page ");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[name$='UnitName']", LabUnitsName, browser, "Fill Conventional Unit");
        senKeys("cssselector", "input[name$='txtSIUnitName']", "SI Unit" + RandomString, browser, "Fill SI Unit");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 3, dependsOnMethods = "addLabUnits")
    public void editLabUnits() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", LabUnitsPageID, browser, "Click on Lab Units Link Page ");
        senKeys("cssselector", "input[id$='txtNameSearch']", LabUnitsName, browser, "Fill Name Search");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4, dependsOnMethods = "addLabUnits")
    public void deleteLabUnits() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", LabUnitsPageID, browser, "Click on Lab Units Link Page ");
        senKeys("cssselector", "input[id$='txtNameSearch']", LabUnitsName, browser, "Fill Name Search");
        clickOnSearchButton(browser);
        Thread.sleep(3000);
        click("cssselector", "input[name*='grdMeasurementUnitsItem']", browser, "Click on The checkBox To Delete");
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
