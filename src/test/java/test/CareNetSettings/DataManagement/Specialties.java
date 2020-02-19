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
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl20_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }


    /*@Test(priority = 1)
    public void navigateToSpecialties() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Specialties Page link ");
        assertByPageName("Specialties");
    }

    String RandomString = generateString();
    String SpecialtiesName = "SpecialtiesName" + RandomString;

    @Test(priority = 2)
    public void addSpecialties() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Specialties Page link ");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtName']", SpecialtiesName, OpenDriver, "Fill the Name ");
        senKeys("cssselector", "input[id$='txtName2']", SpecialtiesName, OpenDriver, "Fill the Name2 ");
        DDLByIndex("select[id$='ddlType']", 1, OpenDriver);
        DDLByIndex("select[id$='ddlGender']", 2, OpenDriver);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addSpecialties")
    public void editSpecialties() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Specialties Page link ");
        senKeys("cssselector", "input[id$='txtNameSearch']", SpecialtiesName, OpenDriver, "Fill Name to Search");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }
*/
    @Test
    public void deleteSpecialties() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Specialties Page link ");
        senKeys("cssselector", "input[id$='txtNameSearch']", "SpecialtiesName2fd3f", OpenDriver, "Fill Name to Search");
        clickOnSearchButton(OpenDriver);
        Thread.sleep(2000);
        click("cssselector", "input[name$='gvSpecialtiesItem']", OpenDriver, "Click on the CheckBox For Delete");
        click("cssselector", "a[id$='ibtnDeleteSpecialty']", OpenDriver, "Click on Delete Buttom");
        acceptTheWebPageAlert(OpenDriver);
        assertOperationDoneSuccessfully();
    }

 /*   @AfterMethod
    public void tearDown(ITestResult result, Method method) {
        if (!result.isSuccess()) {
            screenShot(OpenDriver, result, method.getName());
        }
        OpenDriver.quit();
        Reporter.log("Closing The Browser");
    }*/
}
