package test.CareNetSettings.Cycles;

import Driver.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
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
        loginWithAdminUser(OpenDriver);
        click("cssselector", "[id*=rptApplications_ctl04_lblCSS]", OpenDriver, "Click on CareNet Link");
        click("cssselector", "span[id*='ctl09_lblfontSys']", OpenDriver, "Click on Patient and Visits Link");
        click("id", "rptApplications_ctl04_rptSystem_ctl09_rptModule_ctl00_lblfontMod", OpenDriver, "Click on Reception Link");
        click("id", "rptApplications_ctl04_rptSystem_ctl09_rptModule_ctl00_rptForms_ctl00_lblfontFrm", OpenDriver, "Click on Patient management Link");
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_lblPageName"))).getText();
        String ExpectedResult = "Patients Management";
        Assert.assertEquals(ActualResult, ExpectedResult, "Patients Management not opened");
        Clear("ID", "ctl00_ContentPlaceHolder1_ucPatientRegistration_txtFirstNameSearch", OpenDriver, "Clear First Name Data If founded");
        senKeys("cssselector", "input[id*='txtFirstNameSearch']", FirstName1, OpenDriver, "Send any data in the first name filed  Data to appear new patient button ");
        click("cssselector", "[id*='btnSearchPatient']", OpenDriver, "click on the search button");
        OpenDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        click("id", "ctl00_ContentPlaceHolder1_ucPatientRegistration_btnNewPatient", OpenDriver, "click on the new patient button");
        Clear("cssselector", "input[id*='txtMemberFirstName']", OpenDriver, "Clear First Name Text");
        senKeys("cssselector", "input[id*='txtMemberFirstName']", FirstName2, OpenDriver, "Enter the first name in English");
        senKeys("cssselector", "input[id*='txtMemberMiddleName']", "-", OpenDriver, "Enter the Second  name in English");
        senKeys("cssselector", "input[id*='txtMemberLastName']", "-", OpenDriver, "Enter the Last  name in English");
        senKeys("cssselector", "input[id*='txtMemberFamilyName']", "-", OpenDriver, "Enter the Family  name in English");
        senKeys("cssselector", "input[id*='txtMemberFamilyName2']", "إسم العائلة", OpenDriver, "Enter إسم العائلة");
        senKeys("cssselector", "input[id*='txtMemberLastName2']", "الإسم الأخير", OpenDriver, "Enter الإسم الأخير");
        senKeys("cssselector", "input[id*='txtMemberMiddleName2']", "الإسم الثاني", OpenDriver, "Enter الإسم الثاني");
        senKeys("cssselector", "input[id*='txtMemberFirstName2']", "الإسم الأول", OpenDriver, "Enter الإسم الأول");
        senKeys("cssselector", "input[id*='txtMemberEmail']", "emialrami@yahoo.com", OpenDriver, "Enter the Email");
        TodayDate("img[id*='BirthDate_imgFrom']", "div[id*='today']", OpenDriver);
        Thread.sleep(1000);
        click("cssselector", "input[id*='Gender_0']", OpenDriver, "Select Male Gender ");
        senKeys("cssselector", "input[id*='MemberMobileNo']", "0799114433", OpenDriver, "Enter Mobile No");
        click("cssselector", "input[id*='MemberSecondMobileNo']", OpenDriver, "Click on Second Mobile No ");
        Thread.sleep(2000);
        WebElement SecondMobileNo = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id*='MemberSecondMobileNo']")));
        SecondMobileNo.sendKeys("0799114433", Keys.TAB);
        Reporter.log("Enter Second Mobile No ");
        autoSuggest("img[id*='sggNationality']", "div[id*='dvSuggestions']", OpenDriver);
        String IdentityType = "Declaration";
        DDLByValue("ctl00$ContentPlaceHolder1$ucPatientRegistration$ddlIdentityType", IdentityType, OpenDriver);
        Thread.sleep(1000);
        WebElement IdentityNo = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_ucPatientRegistration_txtIdentityNo")));
        IdentityNo.sendKeys("12345678", Keys.TAB);
        Reporter.log("Enter " + IdentityType + " Number");
        Thread.sleep(1000);
        WebElement IdentityPlaceOfIssue = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_ucPatientRegistration_txtIdentityPlaceOfIssue")));
        IdentityPlaceOfIssue.sendKeys("Place Of Issue", Keys.TAB);
        Reporter.log("Enter " + IdentityType + " Place Of Issue");
        TodayDate("img[id*='dtIdentityIssueDate']", "div[id*='today']", OpenDriver);
        Thread.sleep(1000);
        TodayDate("img[id*='dtIdentityExpireDate']", "div[id*='dtIdentityExpireDate_ext_today']", OpenDriver);
        Thread.sleep(1000);
        DDLByValue("ctl00$ContentPlaceHolder1$ucPatientRegistration$ddlMaritalStatus", "Widower", OpenDriver);
        DDLByValue("ctl00$ContentPlaceHolder1$ucPatientRegistration$ddlBloodGroup", "AB+", OpenDriver);
        autoSuggest("img[id*='SggReferredBy_imgSearch']", "div[id*='SggReferredBy_dvSuggestions']", OpenDriver);
        //click("id", "ctl00_ContentPlaceHolder1_ucPatientRegistration_rdbLstPatientType_0", OpenDriver, "Select Cash Patient");
        DDLByValue("ctl00$ContentPlaceHolder1$ucPatientRegistration$ddlOccupation", "Labor", OpenDriver);
        senKeys("id", "ctl00_ContentPlaceHolder1_ucPatientRegistration_txtExternalNo", "External No", OpenDriver, "Enter External No.");
        senKeys("id", "ctl00_ContentPlaceHolder1_ucPatientRegistration_UcMemberEnrollementAddress_txtAddressLine1", "Address Line 1", OpenDriver, "Enter Address Line 1");
        senKeys("id", "ctl00_ContentPlaceHolder1_ucPatientRegistration_UcMemberEnrollementAddress_txtAddressLine2", "Address Line 2", OpenDriver, "Enter Address Line 2 ");
        senKeys("cssselector", "input[id*='txtContactFirstName']", "First Name", OpenDriver, "Enter Emergency First Name ");
        senKeys("cssselector", "input[id*='txtContactSecondName']", "Second Name", OpenDriver, "Enter Emergency Second Name");
        senKeys("cssselector", "input[id*='txtContactThirdName']", "Third Name", OpenDriver, "Enter Emergency Third Name ");
        DDLByValue("ctl00$ContentPlaceHolder1$ucPatientRegistration$ddlContactRelation", "Spouse", OpenDriver);
        senKeys("cssselector", "input[id*='txtContactMobileNo']", "0799661144", OpenDriver, "Enter Emergency Mobile No. ");
        click("cssselector", "input[id*='btnSaveContact']", OpenDriver, "Click on Add Emergency Contact button");
        OpenDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        click("name", "ctl00$ContentPlaceHolder1$ucPatientRegistration$btnEnrolNewMember", OpenDriver, "Click on Save Button ");
        String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("info_message"))).getText();
        String ExpectedResult1 = "x\n" +
                "Operation Done Successfully .";
        Assert.assertEquals(ActualResult1, ExpectedResult1, "Operation Done Successfully .");

        Thread.sleep(5000);

    }

    @Test(priority = 2,dependsOnMethods = "registerNewPatient")
    public void addNewVisitWithChargeMaster() throws InterruptedException {

        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        click("cssselector", "[id*=rptApplications_ctl04_lblCSS]", OpenDriver, "Click on CareNet Link");
        click("id", "rptApplications_ctl04_rptSystem_ctl09_lblfontSys", OpenDriver, "Click on Patient and Visits Link");
        click("id", "rptApplications_ctl04_rptSystem_ctl09_rptModule_ctl00_lblfontMod", OpenDriver, "Click on Reception Link");
        click("id", "rptApplications_ctl04_rptSystem_ctl09_rptModule_ctl00_rptForms_ctl00_lblfontFrm", OpenDriver, "Click on Patient management Link");
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_lblPageName"))).getText();
        String ExpectedResult = "Patients Management";
        Assert.assertEquals(ActualResult, ExpectedResult, "Patients Management not opened");
        Clear("ID", "ctl00_ContentPlaceHolder1_ucPatientRegistration_txtFirstNameSearch", OpenDriver, "Clear First Name data if exist");
        senKeys("cssselector", "input[id*='FirstNameSearch']", FirstName2, OpenDriver, "Enter the First name");
        //senKeys("cssselector", "input[id*='FirstNameSearch']", "Rami55556", OpenDriver, "Enter the First name");
        click("cssselector", "input[id*='btnSearchPatient']", OpenDriver, "Click on Search button");
        click("cssselector", "span[id*='lblFileNoOrExternalNo']", OpenDriver, "Click on File Number from the Grid Table");
        click("cssselector", "input[id*='btnNewVisit']", OpenDriver, "Click on New Visit button ");
        String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_lblAdmissionDetails"))).getText();
        String ExpectedResult1 = "Visit Details";
        Assert.assertEquals(ActualResult1, ExpectedResult1, "New Visit Page  not opened Successfully");
        autoSuggest("img[id*='sggAdmittingPhysician_imgSearch']", "div[id*='sggAdmittingPhysician_dvSuggestions']", OpenDriver);
        autoSuggest("img[id*='SggReferredBy_imgSearch']", "div[id*='SggReferredBy_dvSuggestions']", OpenDriver);
        autoSuggest("img[id*='sggCountries_imgSearch']", "div[id*='sggCountries_dvSuggestions']", OpenDriver);
        TodayDate("img[id*='dtVisaIssueDate_imgFrom']", "div[id*='ext_today']", OpenDriver);
        senKeys("cssselector", "textarea[name*='txtNote']", "Note", OpenDriver, "Enter Note Description");
        JavascriptExecutor js = (JavascriptExecutor) OpenDriver;
        js.executeScript("window.scrollBy(0,1000)");
        autocomplete("ctl00_ContentPlaceHolder1_tbcServicesAndPackages_tabServices_AutoComplete_UC_txtAutoComplete", "Complete Blood Count (CBC Indices )", OpenDriver);
        Thread.sleep(2000);

        WebElement GridTable = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divMedicalSeriveces")));
        if (GridTable.isDisplayed()) {
            click("id", "ctl00_ContentPlaceHolder1_btnSave", OpenDriver, "Click on Save button");
        } else {
            autocomplete("ctl00_ContentPlaceHolder1_tbcServicesAndPackages_tabServices_AutoComplete_UC_txtAutoComplete", "Complete Blood Count (CBC Indices )", OpenDriver);
            click("id", "ctl00_ContentPlaceHolder1_btnSave", OpenDriver, "Click on Save button");

        }

        WebElement AdmissionNo = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_ucPatientInfoCard_lblAdmissionNo")));
        String ExpectedResultVisit = AdmissionNo.getText();
        String ActualResultVisit = "Visit No";
        Assert.assertEquals(ExpectedResultVisit, ActualResultVisit, "visit card page does not open successfully after we click on save button");
        WebElement VisitNoWait = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_ucPatientInfoCard_lblAdmissionNoText")));
        String VisitNo = VisitNoWait.getText();
        System.out.println("VisitNo===" + VisitNo);
        click("id", "ctl00_ContentPlaceHolder1_uc_VisitDetails_lnkGenerateBill", OpenDriver, "Click on Generate Bill button");
        OpenDriver.switchTo().alert().accept();
        Thread.sleep(30000);

        //Create an ArrayList and store the open tabs
        ArrayList<String> tabs = new ArrayList<String>(OpenDriver.getWindowHandles());
//below code will switch to new tab
        OpenDriver.switchTo().window(tabs.get(1));
//perform whatever actions you want in new tab then close it
        OpenDriver.close();
//Switch back to your original tab
        OpenDriver.switchTo().window(tabs.get(0));

        click("linktext", "Inpatient Management", OpenDriver, "click on Inpatient Management");
        click("id", "ctl00_ucSideMenu_rptSystems_rptModules_4_lbtnModule_6", OpenDriver, "click on Charge Master");
        click("id", "ctl00_ucSideMenu_rptSystems_rptModules_4_rptForms_6_lbtnForm_0", OpenDriver, "click on Charge Master");
        click("id", "ctl00_ContentPlaceHolder1_txtAdmissionNo", OpenDriver, "click on Visit No");
        senKeys("id", "ctl00_ContentPlaceHolder1_txtAdmissionNo", VisitNo, OpenDriver, "Enter Visit Number");
        click("id", "ctl00_ContentPlaceHolder1_btnSearch", OpenDriver, "click on search button");
        WebElement VisitNoChargeMaster = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_ucPatientInfoCard_lblAdmissionNoText")));
        String ActualResultVisitNoChargeMaster = VisitNoChargeMaster.getText();
        String ExpectedResultVisitNoChargeMaster = VisitNo;
        Assert.assertEquals(ActualResultVisitNoChargeMaster, ExpectedResultVisitNoChargeMaster, "Visit Card for the patient not opened in charge master page");

        Thread.sleep(5000);
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

