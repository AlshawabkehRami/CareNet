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
    WebDriver browser;
    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }
    @Test(priority = 1)
    public void navigateToLabTests() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", LabTestsPageID, browser, "Click on Lab Tests Link Page ");
        assertByPageName("Lab Tests");
    }

    String RandomString = generateString();
    String LabTestsName = "LabTestsName" + RandomString;
    @Test(priority = 2)
    public void addLabTests() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", LabTestsPageID, browser, "Click on Lab Tests Link Page ");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='MedicalTestName']", LabTestsName, browser, "Fill  Test Name ");
        senKeys("cssselector", "input[id$='MedicalTestName2']", "Test Name 2" + RandomString, browser, "Fill Test Name 2 ");
        senKeys("cssselector", "input[id$='Alias']", "Alias" + RandomString, browser, "Fill Alias");
        DDLByIndex("select[id$='ddlCategories']", 2, browser);
        Thread.sleep(1000);
        senKeys("cssselector", "input[id$='txtCode']", RandomString, browser, "Fill Code");
        DDLByIndex("select[id$='ddlGender']", 3, browser);
        senKeys("cssselector", "input[id$='txtProHrs']", "12", browser, "Fill Process Hours");
        DDLByIndex("select[id$='ddlSampleType']", 2, browser);
        DDLByIndex("select[id$='ddlLabTestType']", 2, browser);
        DDLByIndex("select[id$='ddlContainerTypes']", 2, browser);
        senKeys("cssselector", "input[id$='txtMinAmount']", "1", browser, "Fill Minimum Amount ");
        senKeys("cssselector", "input[id$='txtPrintingOrder']", "1", browser, "Fill Printing Order");
        DDLByIndex("select[id$='ddlStatus']", 1, browser);
        senKeys("cssselector", "input[id$='txtExpectedTat']", "1", browser, "Fill Expected TAT ");
        DDLByIndex("select[id$='ddlExpectedTatUnit']", 2, browser);
        senKeys("cssselector", "input[id$='txtReportCode']", RandomString, browser, "Fill Report Code");
        senKeys("cssselector", "input[id$='txtWorksheetReportCode']", "Worksheet Report Code", browser, "Fill Worksheet Report Code");
        senKeys("cssselector", "input[id$='txtTestTiming']", "Test Timing", browser, "Fill Test Timing");
        senKeys("cssselector", "input[id$='txtManualTestMethod']", "Manual Test Method", browser, "Fill Manual Test Method");
        senKeys("cssselector", "input[id$='txtStandardCode']", RandomString, browser, "Fill Standard Code");
        senKeys("cssselector", "textarea[id$='txtDefaultComment']", "Default Comment", browser, "Fill Default Comment ");
        senKeys("cssselector", "textarea[id$='txtMedicalTestQuestions']", "Medical Test Questions", browser, "Fill Medical Test Questions");
        senKeys("cssselector", "textarea[id$='txtPreRequisites']", "Instructions", browser, "Fill Instructions");
        scrollDown(browser);
        click("id", "ctl00_ContentPlaceHolder1_btnSave", browser, "Click on Save Button");
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4, dependsOnMethods = "addLabTests")
    public void deleteLabTests() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", LabTestsPageID, browser, "Click on Lab Tests Link Page ");
        senKeys("cssselector", "input[id$='NameSearch']", LabTestsName, browser, "Search By Test Name");
        clickOnSearchButton(browser);
        Thread.sleep(1000);
        click("cssselector", "a[id*='trvLabTestCategoryt1']", browser, "Click on The Labe Test");
        clickOnDeleteButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addLabTests")
    public void editLabTest() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", LabTestsPageID, browser, "Click on Lab Tests Link Page ");
        senKeys("cssselector", "input[id$='NameSearch']", "name", browser, "Search By Test Name");
        clickOnSearchButton(browser);
        Thread.sleep(1000);
        click("cssselector", "a[id*='trvLabTestCategoryt1']", browser, "Click on The Labe Test Name");
        scrollDown(browser);
        click("cssselector", "input[id$='btnUpdate']", browser, "Click on Update Button");
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
