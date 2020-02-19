package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;
/**
 * Created By R.Alshawabkeh 12/4/2019 8:36 AM
 **/
public class ClinicalExamination extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl14_lblfontFrm";
    @BeforeMethod

    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }
    @Test(priority = 1)
    public void navigateToClinicalExamination() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Clinical Examination Page Link");
        assertByPageName("Clinical Examinations");
    }
    String RandomString = generateString();
    String ClinicalExaminationName = "ClinicalExaminationName" + RandomString;
    @Test(priority = 2)
    public void addClinicalExamination() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Clinical Examination Page Link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtMedicalTestName']", ClinicalExaminationName, OpenDriver, "Fill Medical Test Name");
        senKeys("cssselector", "input[id$='txtMedicalTestName2']", ClinicalExaminationName, OpenDriver, "Fill  Medical Test Name 2");
        senKeys("cssselector", "input[id$='txtAlias']", "Alias" + RandomString, OpenDriver, "Fill Alias");
        DDLByIndex("select[id$='ddlCategories']", 1, OpenDriver);
        senKeys("cssselector", "input[id$='txtCode']", "Code" + RandomString, OpenDriver, "Fill The Code ");
        DDLByIndex("select[id$='ddlGender']", 2, OpenDriver);
        senKeys("cssselector", "textarea[id$='txtPreRequisites']", "Prerequisites" + RandomString, OpenDriver, "Fill The Prerequisites ");
        senKeys("cssselector", "textarea[id$='txtDefaultValue']", "Default Value" + RandomString, OpenDriver, "Fill The Default Value ");
        click("cssselector", "input[id$='cbCanBeDoneInsideclinic']", OpenDriver, "Check Can Be Done Inside Clinic");
        click("cssselector", "input[id$='cbcIsActive']", OpenDriver, " Fill Is Active");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 3, dependsOnMethods = "addClinicalExamination")
    public void editClinicalExamination() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Clinical Examination Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", ClinicalExaminationName, OpenDriver, "Fill Name To Search");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 4, dependsOnMethods = "addClinicalExamination")
    public void deleteClinicalExamination() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Clinical Examination Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", ClinicalExaminationName, OpenDriver, "Fill Name To Search");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='grdMedicalTestsItem']", OpenDriver, "Click on checkbox For Delete ");
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
