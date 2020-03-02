package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/3/2019 4:23 PM
 **/
public class Vaccines extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();

    }

    @Test(priority = 1)
    public void navigateToVaccinesPage() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", VaccinesPageID, browser, "Click on Vaccines Link Page");
        assertByPageName("Vaccines");

    }

    String RandomString = generateString();
    String VaccinesName = "VaccinesName" + RandomString;

    @Test(priority = 2)
    public void addVaccines() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", VaccinesPageID, browser, "Click on Vaccines Link Page");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id*='txtVaccineName']", VaccinesName, browser, "Fill Vaccine Name");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3, dependsOnMethods = "addVaccines")
    public void editVaccines() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", VaccinesPageID, browser, "Click on Vaccines Link Page");
        senKeys("cssselector", "input[id*='txtName']", VaccinesName, browser, "Search By Vaccines Name " + VaccinesName);
        clickOnShowAllButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4, dependsOnMethods = "addVaccines")
    public void deleteVaccines() throws InterruptedException {

        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", VaccinesPageID, browser, "Click on Vaccines Link Page");
        senKeys("cssselector", "input[id*='txtName']", VaccinesName, browser, "Search By Vaccines Name " + VaccinesName);
        clickOnShowAllButton(browser);
        click("cssselector", "input[name*='grdVaccinesItem']", browser, "Click on checkBox to delete");
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
