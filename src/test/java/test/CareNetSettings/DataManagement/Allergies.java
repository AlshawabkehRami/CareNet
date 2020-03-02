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
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToAllergiesPage() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", AllergiesPageID, browser, "Click on Allergies Page Link");
        assertByPageName("Allergies");
    }
    String RandomString = generateString();
    String AllergiesName = "AllergiesName" + RandomString;

    @Test(priority = 2)
    public void addAllergies() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", AllergiesPageID, browser, "Click on Allergies Page Link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id*='txtAllergyName']", AllergiesName, browser, "Fill ");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlAllergyType", "Food Allergy", browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();

    }


    @Test(priority = 3, dependsOnMethods = "addAllergies")
    public void editAllergies() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", AllergiesPageID, browser, "Click on Allergies Page Link");
        senKeys("cssselector", "input[id*='txtName']", AllergiesName, browser, "Fill Search field with");
        clickOnShowAllButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4, dependsOnMethods = "addAllergies")
    public void deleteAllergies() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", AllergiesPageID, browser, "Click on Allergies Page Link");
        senKeys("cssselector", "input[id*='txtName']", AllergiesName, browser, "Fill Search field with");
        clickOnShowAllButton(browser);
        click("cssselector", "input[name*='grdAllergiesItem']", browser, "Clicko on CheckBox to delete");
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
