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
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl06_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToMedicalServices() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Services link page");
        assertByPageName("Medical Services");
    }

    String RandomString = generateString();
    String MedicalServicesName = "MedicalServicesName" + RandomString;

    @Test(priority = 2)
    public void addMedicalServices() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Services link page");
        clickOnAddButton(OpenDriver);
        senKeys("id", "ctl00_ContentPlaceHolder1_txtCode", RandomString, OpenDriver, "Fill the Code ");
        senKeys("id", "ctl00_ContentPlaceHolder1_txtName", MedicalServicesName, OpenDriver, "Fill the Medical Services Name" + MedicalServicesName);
        DDLByValue("ctl00$ContentPlaceHolder1$ddlServiceTypeEntry", "SERVICE", OpenDriver);
        Thread.sleep(500);
        senKeys("id", "ctl00_ContentPlaceHolder1_txtVAT", "25", OpenDriver, "Fill VAT%");
        click("cssselector", "input[id*='cbIsStandard']", OpenDriver, "Click on Is Standard");
        click("cssselector", "input[id*='chkNeedsUpload']", OpenDriver, "Click Needs Upload");
        click("cssselector", "input[id*='cbIsAnesthesia']", OpenDriver, "Click Is Anesthesia");
        click("cssselector", "input[id*='cbIsConsultation']", OpenDriver, "Click Is Consultation");
        senKeys("cssselector", "input[id*='txtStandardCode']", RandomString, OpenDriver, "Fill Standard Code");
        senKeys("cssselector", "input[id*='txtServicePoint']", "15", OpenDriver, "Fill Service Points");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addMedicalServices")
    public void editMedicalServices() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Services link page");
        senKeys("id", "ctl00_ContentPlaceHolder1_txtNameSearch", MedicalServicesName, OpenDriver, "Searching for " + MedicalServicesName);
        click("cssselector", "input[id*='btnSerach']", OpenDriver, "Click on Search Button");
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4, dependsOnMethods = "addMedicalServices")
    public void deleteMedicalServices() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medical Services link page");
        senKeys("id", "ctl00_ContentPlaceHolder1_txtNameSearch", MedicalServicesName, OpenDriver, "Searching for :: " + MedicalServicesName);
        click("cssselector", "input[id*='btnSerach']", OpenDriver, "Click on Search Button");
        click("cssselector", "input[name*='gvServicesItem']", OpenDriver, "Click on CheckBox To delete");
        clickOnDeleteButton(OpenDriver);
        // click("cssselector", "a[id*='ibtnDelete']", OpenDriver, "Click on Delete Button");
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
