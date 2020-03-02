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
    WebDriver browser;
    @BeforeMethod

    public void setUp() {
        browser=theBrowser();

    }
    @Test(priority = 1)
    public void navigateToClinicalExamination() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", ClinicalExaminationPageID, browser, "Click on Clinical Examination Page Link");
        assertByPageName("Clinical Examinations");
    }
    String RandomString = generateString();
    String ClinicalExaminationName = "ClinicalExaminationName" + RandomString;
    @Test(priority = 2)
    public void addClinicalExamination() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", ClinicalExaminationPageID, browser, "Click on Clinical Examination Page Link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtMedicalTestName']", ClinicalExaminationName, browser, "Fill Medical Test Name");
        senKeys("cssselector", "input[id$='txtMedicalTestName2']", ClinicalExaminationName, browser, "Fill  Medical Test Name 2");
        senKeys("cssselector", "input[id$='txtAlias']", "Alias" + RandomString, browser, "Fill Alias");
        DDLByIndex("select[id$='ddlCategories']", 1, browser);
        senKeys("cssselector", "input[id$='txtCode']", "Code" + RandomString, browser, "Fill The Code ");
        DDLByIndex("select[id$='ddlGender']", 2, browser);
        senKeys("cssselector", "textarea[id$='txtPreRequisites']", "Prerequisites" + RandomString, browser, "Fill The Prerequisites ");
        senKeys("cssselector", "textarea[id$='txtDefaultValue']", "Default Value" + RandomString, browser, "Fill The Default Value ");
        click("cssselector", "input[id$='cbCanBeDoneInsideclinic']", browser, "Check Can Be Done Inside Clinic");
        click("cssselector", "input[id$='cbcIsActive']", browser, " Fill Is Active");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 3, dependsOnMethods = "addClinicalExamination")
    public void editClinicalExamination() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", ClinicalExaminationPageID, browser, "Click on Clinical Examination Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", ClinicalExaminationName, browser, "Fill Name To Search");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 4, dependsOnMethods = "addClinicalExamination")
    public void deleteClinicalExamination() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", ClinicalExaminationPageID, browser, "Click on Clinical Examination Page Link");
        senKeys("cssselector", "input[id$='txtNameSearch']", ClinicalExaminationName, browser, "Fill Name To Search");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdMedicalTestsItem']", browser, "Click on checkbox For Delete ");
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
