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

    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl03_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");

    }

    @Test(priority = 1)
    public void navigateToVaccinesPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Vaccines Link Page");
        assertByPageName("Vaccines");

    }

    String RandomString = generateString();
    String VaccinesName = "VaccinesName" + RandomString;

    @Test(priority = 2)
    public void addVaccines() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Vaccines Link Page");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id*='txtVaccineName']", VaccinesName, OpenDriver, "Fill Vaccine Name");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3, dependsOnMethods = "addVaccines")
    public void editVaccines() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Vaccines Link Page");
        senKeys("cssselector", "input[id*='txtName']", VaccinesName, OpenDriver, "Search By Vaccines Name " + VaccinesName);
        clickOnShowAllButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4, dependsOnMethods = "addVaccines")
    public void deleteVaccines() throws InterruptedException {

        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Vaccines Link Page");
        senKeys("cssselector", "input[id*='txtName']", VaccinesName, OpenDriver, "Search By Vaccines Name " + VaccinesName);
        clickOnShowAllButton(OpenDriver);
        click("cssselector", "input[name*='grdVaccinesItem']", OpenDriver, "Click on checkBox to delete");
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
