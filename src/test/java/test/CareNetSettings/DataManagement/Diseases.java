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
    WebDriver browser;
    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }
    @Test(priority = 1)
    public void navigateToDiseasesPage() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", DiseasesPageID, browser, "Click on Diseases page link");
        assertByPageName("Diseases");
    }
    String RandomString = generateString();
    String DiseasesName = "DiseasesName" + RandomString;


    @Test(priority = 2)
    public void addDiseases() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", DiseasesPageID, browser, "Click on Diseases page link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id*='txtDiseaseName']", DiseasesName, browser, "Fill Disease Name");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlCodingSystem", "Not Standard", browser);
        senKeys("id", "ctl00_ContentPlaceHolder1_txtCode", "Code" + RandomString, browser, "Fill The Code");
        senKeys("cssselector", "input[id*='txtIcdCode']", "ICD Code" + RandomString, browser, "Fill The ICD Code");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlGender", "Both", browser);
        senKeys("cssselector", "input[id*='txtAgeFrom']", "18", browser, "Fill Age From");
        senKeys("cssselector", "input[id*='txtAgeTo']", "99", browser, "Fill Age From");
        senKeys("cssselector", "input[id*='txtDiseaseAlias']", "Disease Alias", browser, "Fill Disease Alias");
        senKeys("cssselector", "input[id*='txtFrequency']", "122" + RandomString, browser, "Fill The Frequency");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 3, dependsOnMethods = "addDiseases")
    public void editDiseases() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", DiseasesPageID, browser, "Click on Diseases page link");
        senKeys("cssselector", "input[id*='txtNameSearch']", DiseasesName, browser, "Search for the name of the disease" + DiseasesName);
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addDiseases")
    public void deletDiseases() throws InterruptedException {

        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", DiseasesPageID, browser, "Click on Diseases page link");
        senKeys("cssselector", "input[id*='txtNameSearch']", DiseasesName, browser, "Search for the name of the disease" + DiseasesName);
        clickOnSearchButton(browser);
        click("cssselector", "input[name*='grdDiseasesItem']", browser, "Clicko on CheckBox to delete");
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
