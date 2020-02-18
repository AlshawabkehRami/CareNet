package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;
/**
 * Created By R.Alshawabkeh 12/3/2019 5:02 PM
 **/
public class LabTests extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl12_lblfontFrm";
    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }
    @Test(priority = 1)
    public void navigateToLabTests() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Tests Link Page ");
        assertByPageName("Lab Tests");
    }
    String RandomString = generateString();
    String LabTestsName = "LabTestsName" + RandomString;
    @Test(priority = 2)
    public void addLabTests() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Tests Link Page ");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='MedicalTestName']", LabTestsName, OpenDriver, "Fill  Test Name ");
        senKeys("cssselector", "input[id$='MedicalTestName2']", "Test Name 2" + RandomString, OpenDriver, "Fill Test Name 2 ");
        senKeys("cssselector", "input[id$='Alias']", "Alias" + RandomString, OpenDriver, "Fill Alias");
        DDLByIndex("select[id$='ddlCategories']", 2, OpenDriver);
        Thread.sleep(1000);
        senKeys("cssselector", "input[id$='txtCode']", RandomString, OpenDriver, "Fill Code");
        DDLByIndex("select[id$='ddlGender']", 3, OpenDriver);
        senKeys("cssselector", "input[id$='txtProHrs']", "12", OpenDriver, "Fill Process Hours");
        DDLByIndex("select[id$='ddlSampleType']", 2, OpenDriver);
        DDLByIndex("select[id$='ddlLabTestType']", 2, OpenDriver);
        DDLByIndex("select[id$='ddlContainerTypes']", 2, OpenDriver);
        senKeys("cssselector", "input[id$='txtMinAmount']", "1", OpenDriver, "Fill Minimum Amount ");
        senKeys("cssselector", "input[id$='txtPrintingOrder']", "1", OpenDriver, "Fill Printing Order");
        DDLByIndex("select[id$='ddlStatus']", 1, OpenDriver);
        senKeys("cssselector", "input[id$='txtExpectedTat']", "1", OpenDriver, "Fill Expected TAT ");
        DDLByIndex("select[id$='ddlExpectedTatUnit']", 2, OpenDriver);
        senKeys("cssselector", "input[id$='txtReportCode']", RandomString, OpenDriver, "Fill Report Code");
        senKeys("cssselector", "input[id$='txtWorksheetReportCode']", "Worksheet Report Code", OpenDriver, "Fill Worksheet Report Code");
        senKeys("cssselector", "input[id$='txtTestTiming']", "Test Timing", OpenDriver, "Fill Test Timing");
        senKeys("cssselector", "input[id$='txtManualTestMethod']", "Manual Test Method", OpenDriver, "Fill Manual Test Method");
        senKeys("cssselector", "input[id$='txtStandardCode']", RandomString, OpenDriver, "Fill Standard Code");
        senKeys("cssselector", "textarea[id$='txtDefaultComment']", "Default Comment", OpenDriver, "Fill Default Comment ");
        senKeys("cssselector", "textarea[id$='txtMedicalTestQuestions']", "Medical Test Questions", OpenDriver, "Fill Medical Test Questions");
        senKeys("cssselector", "textarea[id$='txtPreRequisites']", "Instructions", OpenDriver, "Fill Instructions");
        scrollDown(OpenDriver);
        click("id", "ctl00_ContentPlaceHolder1_btnSave", OpenDriver, "Click on Save Button");
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4, dependsOnMethods = "addLabTests")
    public void deleteLabTests() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Tests Link Page ");
        senKeys("cssselector", "input[id$='NameSearch']", LabTestsName, OpenDriver, "Search By Test Name");
        clickOnSearchButton(OpenDriver);
        Thread.sleep(1000);
        click("cssselector", "a[id*='trvLabTestCategoryt1']", OpenDriver, "Click on The Labe Test");
        clickOnDeleteButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addLabTests")
    public void editLabTest() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Lab Tests Link Page ");
        senKeys("cssselector", "input[id$='NameSearch']", "name", OpenDriver, "Search By Test Name");
        clickOnSearchButton(OpenDriver);
        Thread.sleep(1000);
        click("cssselector", "a[id*='trvLabTestCategoryt1']", OpenDriver, "Click on The Labe Test Name");
        scrollDown(OpenDriver);
        click("cssselector", "input[id$='btnUpdate']", OpenDriver, "Click on Update Button");
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
