package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/4/2019 8:58 AM
 **/
public class MedicalFormCodes extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToMedicalFormCodes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalFormCodesPageID, browser, "Click on Medical Form Codes Page link ");
        assertByPageName("Medical Form Codes");
    }

    String RandomString = generateString();
    String Name = "Name" + RandomString;


    @Test(priority = 2)
    public void addMedicalFormCodes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalFormCodesPageID, browser, "Click on Medical Form Codes Page link ");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtName']", Name, browser, "Fill The Name ");
        DDLByIndex("select[id$='ddlAttributeCodeCategory']", 1, browser);
        senKeys("cssselector", "textarea[id$='txtName2']", Name, browser, "Fill The Item Description ");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addMedicalFormCodes")
    public void editMedicalFormCodes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalFormCodesPageID, browser, "Click on Medical Form Codes Page link ");
        senKeys("cssselector", "input[id$='txtNameSearch']", Name, browser, "Fill Name for Search");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addMedicalFormCodes")
    public void deleteMedicalFormCodes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalFormCodesPageID, browser, "Click on Medical Form Codes Page link ");
        senKeys("cssselector", "input[id$='txtNameSearch']", Name, browser, "Fill Name for Search");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdhFormAttributeCodesItem']", browser, "Click on The CheckBox to Delete");
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
