package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/4/2019 8:45 AM
 **/
public class MedicalForms extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToMedicalForms() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalFormsPageID, browser, "Click on Medical Forms PageLink");
        assertByPageName("Medical Forms");
    }

    String RandomString = generateString();
    String FormName = "FormName" + RandomString;


    @Test(priority = 2)
    public void addMedicalForms() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalFormsPageID, browser, "Click on Medical Forms PageLink");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtMedicalTestName']", FormName, browser, "Fill Form Name ");
        senKeys("cssselector", "input[id$='txtMedicalTestName2']", "Form Name 2" + RandomString, browser, "Fill Form Name2 ");
        senKeys("cssselector", "input[id$='txtCode']", "Code" + RandomString, browser, "Fill Code ");
        DDLByIndex("select[id$='ddlMedicalTypeDetails']", 1, browser);
        DDLByIndex("select[id$='ddlCategories']", 1, browser);
        senKeys("cssselector", "input[id$='txtFormOrder']", RandomString, browser, "Fill Order ");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3, dependsOnMethods = "addMedicalForms")
    public void editMedicalForms() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalFormsPageID, browser, "Click on Medical Forms PageLink");
        senKeys("cssselector", "input[id$='txtNameSearch']", FormName, browser, "Fill  Form Name for search");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addMedicalForms")
    public void deleteMedicalForms() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalFormsPageID, browser, "Click on Medical Forms PageLink");
        senKeys("cssselector", "input[id$='txtNameSearch']", FormName, browser, "Fill  Form Name for search");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdMedicalTestsItem']", browser, "Click on the checkbox for Delete");
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
