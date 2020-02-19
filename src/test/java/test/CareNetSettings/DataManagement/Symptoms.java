package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;


public class Symptoms extends BasePage {
    WebDriver driver;
    public static WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl00_lblfontFrm";

    @BeforeMethod
    public void setUp(Method method) {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToSymptomsPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Symptoms Page Link");
        Wait = new WebDriverWait(OpenDriver, 20);
        assertByPageName("Symptoms");

    }

    String SymptomName1 = generateString();
    String SymptomName2 = "SymptomName" + SymptomName1;

    @Test(priority = 2, dependsOnMethods = "navigateToSymptomsPage")
    public void addSymptoms() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Symptoms Page Link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id*='txtSymptomName']", SymptomName2, OpenDriver, "Fill Symptom Name");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlSymptomGroup", "Allergic", OpenDriver);
        DDLByValue("ctl00$ContentPlaceHolder1$ddlGender", "Both", OpenDriver);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 3, dependsOnMethods = "addSymptoms")
    public void editSymptoms() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Symptoms Page Link");
        senKeys("cssselector", "input[id*='txtName']", SymptomName2, OpenDriver, "Enter Symptom Name");
        clickOnShowAllButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4, dependsOnMethods = "addSymptoms")
    public void deleteSymptoms() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Symptoms Page Link");
        senKeys("cssselector", "input[id*='txtName']", SymptomName2, OpenDriver, "Enter Symptom Name");
        click("cssselector", "input[id*='btnShowAll']", OpenDriver, "Click on Search Button");
        click("cssselector", "input[name*='grdSymptomsItem']", OpenDriver, "Click on The checkbos to delete");
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



