package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/4/2019 9:02 AM
 **/
public class Specialties extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToSpecialties() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SpecialtiesPageID, browser, "Click on Specialties Page link ");
        assertByPageName("Specialties");
    }

    String RandomString = generateString();
    String SpecialtiesName = "SpecialtiesName" + RandomString;

    @Test(priority = 2)
    public void addSpecialties() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SpecialtiesPageID, browser, "Click on Specialties Page link ");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtName']", SpecialtiesName, browser, "Fill the Name ");
        senKeys("cssselector", "input[id$='txtName2']", SpecialtiesName, browser, "Fill the Name2 ");
        DDLByIndex("select[id$='ddlType']", 1, browser);
        DDLByIndex("select[id$='ddlGender']", 2, browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addSpecialties")
    public void editSpecialties() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SpecialtiesPageID, browser, "Click on Specialties Page link ");
        senKeys("cssselector", "input[id$='txtNameSearch']", SpecialtiesName, browser, "Fill Name to Search");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test
    public void deleteSpecialties() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", SpecialtiesPageID, browser, "Click on Specialties Page link ");
        senKeys("cssselector", "input[id$='txtNameSearch']", "SpecialtiesName2fd3f", browser, "Fill Name to Search");
        clickOnSearchButton(browser);
        Thread.sleep(2000);
        click("cssselector", "input[name$='gvSpecialtiesItem']", browser, "Click on the CheckBox For Delete");
        click("cssselector", "a[id$='ibtnDeleteSpecialty']", browser, "Click on Delete Buttom");
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
