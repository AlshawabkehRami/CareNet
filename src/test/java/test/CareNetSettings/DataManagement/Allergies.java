package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;

/**
 * C@BeforeMethod
 * public void setUp() {
 * OpenDriver = driverType(driver, "chrome");
 * }reated By R.Alshawabkeh 12/3/2019 4:20 PM
 **/
public class Allergies extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl02_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToAllergiesPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Allergies Page Link");
        assertByPageName("Allergies");
    }

    String RandomString = generateString();
    String AllergiesName = "AllergiesName" + RandomString;

    @Test(priority = 2)
    public void addAllergies() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Allergies Page Link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id*='txtAllergyName']", AllergiesName, OpenDriver, "Fill ");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlAllergyType", "Food Allergy", OpenDriver);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 3, dependsOnMethods = "addAllergies")
    public void editAllergies() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Allergies Page Link");
        senKeys("cssselector", "input[id*='txtName']", AllergiesName, OpenDriver, "Fill Search field with");
        clickOnShowAllButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4, dependsOnMethods = "addAllergies")
    public void deleteAllergies() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Allergies Page Link");
        senKeys("cssselector", "input[id*='txtName']", AllergiesName, OpenDriver, "Fill Search field with");
        clickOnShowAllButton(OpenDriver);
        click("cssselector", "input[name*='grdAllergiesItem']", OpenDriver, "Clicko on CheckBox to delete");
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
