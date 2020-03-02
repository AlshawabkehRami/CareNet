package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;


public class Symptoms extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp(Method method) {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToSymptomsPage() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SymptomsPageID, browser, "Click on Symptoms Page Link");
        Wait = new WebDriverWait(browser, 20);
        assertByPageName("Symptoms");

    }

    String SymptomName1 = generateString();
    String SymptomName2 = "SymptomName" + SymptomName1;

    @Test(priority = 2, dependsOnMethods = "navigateToSymptomsPage")
    public void addSymptoms() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SymptomsPageID, browser, "Click on Symptoms Page Link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id*='txtSymptomName']", SymptomName2, browser, "Fill Symptom Name");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlSymptomGroup", "Allergic", browser);
        DDLByValue("ctl00$ContentPlaceHolder1$ddlGender", "Both", browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 3, dependsOnMethods = "addSymptoms")
    public void editSymptoms() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SymptomsPageID, browser, "Click on Symptoms Page Link");
        senKeys("cssselector", "input[id*='txtName']", SymptomName2, browser, "Enter Symptom Name");
        clickOnShowAllButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4, dependsOnMethods = "addSymptoms")
    public void deleteSymptoms() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SymptomsPageID, browser, "Click on Symptoms Page Link");
        senKeys("cssselector", "input[id*='txtName']", SymptomName2, browser, "Enter Symptom Name");
        click("cssselector", "input[id*='btnShowAll']", browser, "Click on Search Button");
        click("cssselector", "input[name*='grdSymptomsItem']", browser, "Click on The checkbos to delete");
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



