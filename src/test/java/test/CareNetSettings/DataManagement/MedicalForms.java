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
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl16_lnkForms";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToMedicalForms() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Forms PageLink");
        assertByPageName("Medical Forms");
    }

    String RandomString = generateString();
    String FormName = "FormName" + RandomString;

    @Test(priority = 2)
    public void addMedicalForms() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Forms PageLink");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtMedicalTestName']", FormName, OpenDriver, "Fill Form Name ");
        senKeys("cssselector", "input[id$='txtMedicalTestName2']", "Form Name 2" + RandomString, OpenDriver, "Fill Form Name2 ");
        senKeys("cssselector", "input[id$='txtCode']", "Code" + RandomString, OpenDriver, "Fill Code ");
        DDLByIndex("select[id$='ddlMedicalTypeDetails']", 1, OpenDriver);
        DDLByIndex("select[id$='ddlCategories']", 1, OpenDriver);
        senKeys("cssselector", "input[id$='txtFormOrder']", RandomString, OpenDriver, "Fill Order ");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3, dependsOnMethods = "addMedicalForms")
    public void editMedicalForms() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Forms PageLink");
        senKeys("cssselector", "input[id$='txtNameSearch']", FormName, OpenDriver, "Fill  Form Name for search");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addMedicalForms")
    public void deleteMedicalForms() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Forms PageLink");
        senKeys("cssselector", "input[id$='txtNameSearch']", FormName, OpenDriver, "Fill  Form Name for search");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='grdMedicalTestsItem']", OpenDriver, "Click on the checkbox for Delete");
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
