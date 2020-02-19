package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;


/**
 * Created By R.Alshawabkeh 12/3/2019 4:02 PM
 **/

public class Diseases extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl01_lblfontFrm";
    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }
    @Test(priority = 1)
    public void navigateToDiseasesPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Diseases page link");
        assertByPageName("Diseases");
    }
    String RandomString = generateString();
    String DiseasesName = "DiseasesName" + RandomString;


    @Test(priority = 2)
    public void addDiseases() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Diseases page link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id*='txtDiseaseName']", DiseasesName, OpenDriver, "Fill Disease Name");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlCodingSystem", "Not Standard", OpenDriver);
        senKeys("id", "ctl00_ContentPlaceHolder1_txtCode", "Code" + RandomString, OpenDriver, "Fill The Code");
        senKeys("cssselector", "input[id*='txtIcdCode']", "ICD Code" + RandomString, OpenDriver, "Fill The ICD Code");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlGender", "Both", OpenDriver);
        senKeys("cssselector", "input[id*='txtAgeFrom']", "18", OpenDriver, "Fill Age From");
        senKeys("cssselector", "input[id*='txtAgeTo']", "99", OpenDriver, "Fill Age From");
        senKeys("cssselector", "input[id*='txtDiseaseAlias']", "Disease Alias", OpenDriver, "Fill Disease Alias");
        senKeys("cssselector", "input[id*='txtFrequency']", "122" + RandomString, OpenDriver, "Fill The Frequency");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 3, dependsOnMethods = "addDiseases")
    public void editDiseases() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Diseases page link");
        senKeys("cssselector", "input[id*='txtNameSearch']", DiseasesName, OpenDriver, "Search for the name of the disease" + DiseasesName);
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addDiseases")
    public void deletDiseases() throws InterruptedException {

        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Diseases page link");
        senKeys("cssselector", "input[id*='txtNameSearch']", DiseasesName, OpenDriver, "Search for the name of the disease" + DiseasesName);
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name*='grdDiseasesItem']", OpenDriver, "Clicko on CheckBox to delete");
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
