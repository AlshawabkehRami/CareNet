package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;


/**
 * Created By R.Alshawabkeh 12/3/2019 4:31 PM
 **/
public class MedicalServices extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToMedicalServices() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalServicesPageID, browser, "Click on Medical Services link page");
        assertByPageName("Medical Services");
    }

    String RandomString = generateString();
    String MedicalServicesName = "MedicalServicesName" + RandomString;

    @Test(priority = 2)
    public void addMedicalServices() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalServicesPageID, browser, "Click on Medical Services link page");
        clickOnAddButton(browser);
        senKeys("id", "ctl00_ContentPlaceHolder1_txtCode", RandomString, browser, "Fill the Code ");
        senKeys("id", "ctl00_ContentPlaceHolder1_txtName", MedicalServicesName, browser, "Fill the Medical Services Name" + MedicalServicesName);
        DDLByValue("ctl00$ContentPlaceHolder1$ddlServiceTypeEntry", "SERVICE", browser);
        Thread.sleep(500);
        senKeys("id", "ctl00_ContentPlaceHolder1_txtVAT", "25", browser, "Fill VAT%");
        click("cssselector", "input[id*='cbIsStandard']", browser, "Click on Is Standard");
        click("cssselector", "input[id*='chkNeedsUpload']", browser, "Click Needs Upload");
        click("cssselector", "input[id*='cbIsAnesthesia']", browser, "Click Is Anesthesia");
        click("cssselector", "input[id*='cbIsConsultation']", browser, "Click Is Consultation");
        senKeys("cssselector", "input[id*='txtStandardCode']", RandomString, browser, "Fill Standard Code");
        senKeys("cssselector", "input[id*='txtServicePoint']", "15", browser, "Fill Service Points");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addMedicalServices")
    public void editMedicalServices() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalServicesPageID, browser, "Click on Medical Services link page");
        senKeys("id", "ctl00_ContentPlaceHolder1_txtNameSearch", MedicalServicesName, browser, "Searching for " + MedicalServicesName);
        click("cssselector", "input[id*='btnSerach']", browser, "Click on Search Button");
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4, dependsOnMethods = "addMedicalServices")
    public void deleteMedicalServices() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalServicesPageID, browser, "Click on Medical Services link page");
        senKeys("id", "ctl00_ContentPlaceHolder1_txtNameSearch", MedicalServicesName, browser, "Searching for :: " + MedicalServicesName);
        click("cssselector", "input[id*='btnSerach']", browser, "Click on Search Button");
        click("cssselector", "input[name*='gvServicesItem']", browser, "Click on CheckBox To delete");
        clickOnDeleteButton(browser);
        // click("cssselector", "a[id*='ibtnDelete']", OpenDriver, "Click on Delete Button");
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
