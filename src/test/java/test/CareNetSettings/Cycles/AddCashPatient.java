package test.CareNetSettings.Cycles;

import Driver.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created By R.Alshawabkeh 1/29/2020 2:35 PM
 **/

public class AddCashPatient extends BasePage {

    WebDriver driver;
    WebDriver OpenDriver;
    String FirstName1 = generateString();
    String FirstName2 = "Rami" + FirstName1;


    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void registerNewPatient() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        click("cssselector", "[id*=rptApplications_ctl04_lblCSS]", OpenDriver,"StepDescription");



    }

   /* @Test(priority = 2)
    public void addNewVisit() throws InterruptedException {

        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        click("cssselector", "[id*=rptApplications_ctl04_lblCSS]", OpenDriver);
        Reporter.log("Click on CareNet Link");
        click("id", "rptApplications_ctl04_rptSystem_ctl09_lblfontSys", OpenDriver);
        Reporter.log("Click on Patient and Visits Link");
        click("id", "rptApplications_ctl04_rptSystem_ctl09_rptModule_ctl00_lblfontMod", OpenDriver);
        Reporter.log("Click on Reception Link");
        click("id", "rptApplications_ctl04_rptSystem_ctl09_rptModule_ctl00_rptForms_ctl00_lblfontFrm", OpenDriver);
        Reporter.log("Click on Patient management Link");
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_lblPageName"))).getText();
        String ExpectedResult = "Patients Management";
        Assert.assertEquals(ActualResult, ExpectedResult, "Patients Management not opened");
        Clear("ID", "ctl00_ContentPlaceHolder1_ucPatientRegistration_txtFirstNameSearch", OpenDriver);
        Reporter.log("Clear First Name data if exist");
        senKeys("cssselector", "input[id*='FirstNameSearch']", FirstName2, OpenDriver);
        // senKeys("cssselector", "input[id*='FirstNameSearch']", "Rami55556", OpenDriver);
        Reporter.log("Fill First Name filed with name the patient");
        click("cssselector", "input[id*='btnSearchPatient']", OpenDriver);
        Reporter.log("Click on Search button");
        click("cssselector", "span[id*='lblFileNoOrExternalNo']", OpenDriver);
        Reporter.log("Click on File Number from the Grid Table");
        click("cssselector", "input[id*='btnNewVisit']", OpenDriver);
        Reporter.log("Click on New Visit button ");


        String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_lblAdmissionDetails"))).getText();
        String ExpectedResult1 = "Visit Details";
        Assert.assertEquals(ActualResult1, ExpectedResult1, "New Visit Page  not opened Successfully");
        autoSuggest("img[id*='sggAdmittingPhysician_imgSearch']", "div[id*='sggAdmittingPhysician_dvSuggestions']", OpenDriver);
        autoSuggest("img[id*='SggReferredBy_imgSearch']", "div[id*='SggReferredBy_dvSuggestions']", OpenDriver);
        autoSuggest("img[id*='sggCountries_imgSearch']", "div[id*='sggCountries_dvSuggestions']", OpenDriver);
        TodayDate("img[id*='dtVisaIssueDate_imgFrom']", "div[id*='ext_today']", OpenDriver);
        senKeys("cssselector", "textarea[name*='txtNote']", "Note", OpenDriver);

        JavascriptExecutor js = (JavascriptExecutor) OpenDriver;
        js.executeScript("window.scrollBy(0,1000)");
        autocomplete("ctl00_ContentPlaceHolder1_tbcServicesAndPackages_tabServices_AutoComplete_UC_txtAutoComplete", "Complete Blood Count (CBC Indices )", OpenDriver);
        Thread.sleep(2000);

        WebElement GridTable = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divMedicalSeriveces")));
        if (GridTable.isDisplayed()) {
            click("id", "ctl00_ContentPlaceHolder1_btnSave", OpenDriver);
        } else {
            autocomplete("ctl00_ContentPlaceHolder1_tbcServicesAndPackages_tabServices_AutoComplete_UC_txtAutoComplete", "Complete Blood Count (CBC Indices )", OpenDriver);
            click("id", "ctl00_ContentPlaceHolder1_btnSave", OpenDriver);

        }

        WebElement AdmissionNo = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_ucPatientInfoCard_lblAdmissionNo")));
        String ExpectedResultVisit = AdmissionNo.getText();
        String ActualResultVisit = "Visit No";

        Assert.assertEquals(ExpectedResultVisit, ActualResultVisit, "visit card page does not open successfully after we click on save button");


    }
*/

  /*  @AfterMethod
    public void tearDown(ITestResult result, Method method) {
        if (!result.isSuccess()) {
            screenShot(OpenDriver, result, method.getName());
        }
        OpenDriver.quit();
        Reporter.log("Closing The Browser");
    }
*/
}

