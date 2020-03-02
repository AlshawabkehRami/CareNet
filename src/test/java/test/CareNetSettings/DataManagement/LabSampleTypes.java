package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;
/**
 *
 * Created By R.Alshawabkeh 12/3/2019 4:36 PM
 **/
public class LabSampleTypes extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }
    @Test(priority = 1)
    public void navigateToLabSampleTypes() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", LabSampleTypesPageID, browser, "Click on Lab Sample Types link Page");
        assertByPageName("Lab Sample Types");
    }
    String RandomString = generateString();
    String SampleTypesName = "SampleTypesName" + RandomString;
    @Test(priority = 2)
    public void addLabSampleTypes() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", LabSampleTypesPageID, browser, "Click on Lab Sample Types link Page");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtName']", SampleTypesName, browser, "Fill Name");
        senKeys("cssselector", "input[id$='txtValidityHours']", "15", browser, "Fill Validity Hours");
        senKeys("cssselector", "input[id$='txtMinimumTemperature']", "1", browser, "Fill Min Temperature");
        senKeys("cssselector", "input[id$='txtMaximumTemperature']", "50", browser, "Fill Max Temperature");
        senKeys("cssselector", "textarea[id$='txtInstructions']", "Instructions" + RandomString, browser, "Fill Instructions");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3, dependsOnMethods = "addLabSampleTypes")
    public void editLabSampleTypes() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", LabSampleTypesPageID, browser, "Click on Lab Sample Types link Page");
        senKeys("cssselector", "input[id$='txtSampleTypeName']", SampleTypesName, browser, "Searching for Sample Types Name");
        clickOnSearchButton(browser);
        Thread.sleep(7000);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4, dependsOnMethods = "addLabSampleTypes")
    public void deleteLabSampleTypes() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", LabSampleTypesPageID, browser, "Click on Lab Sample Types link Page");
        senKeys("cssselector", "input[id$='txtSampleTypeName']", SampleTypesName, browser, "Searching for Sample Types Name");
        clickOnSearchButton(browser);
        Thread.sleep(5000);
        click("cssselector", "input[name*='gvSampleTypesItem']", browser, "Click on the CheckBox to delete");
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
