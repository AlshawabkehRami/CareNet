package test.CareNetSettings.MedicalProviders;
import Driver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/20/2020 6:10 PM
 **/
public class BranchSettings extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl02_lblfontFrm";


    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

        @Test(priority = 1)

        public void navigateToBranchSettings() throws InterruptedException {
            navigateToUrl(OpenDriver);
            loginWithAdminUser(OpenDriver);
            NavigateToMedicalProvidersLink(OpenDriver);
            click("id", PageLinkLocator, OpenDriver, "Click on Branch Settings Page Link");
            assertByPageName("Branch Settings");
        }
    @Test(priority = 2)
    public void checkAllOptionsInBranchSettings() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToMedicalProvidersLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Branch Settings Page Link");
        Thread.sleep(2000);
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbIsIdentityNoRequired']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbIsIdentityNoRequired']")).click();
            Reporter.log("Select The Option Is Identity No Required");
        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbMaritalStatus']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbMaritalStatus']")).click();
            Reporter.log("Select The Option Show Marital Status");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbShowAddressInfoHint']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbShowAddressInfoHint']")).click();
            Reporter.log("Select The Option Show Address Info Hint");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbLastName2']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbLastName2']")).click();
            Reporter.log("Select The Option Patient Third Name");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbEnableResultValidationFingerprint']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbEnableResultValidationFingerprint']")).click();
            Reporter.log("Select The Option Enable Result Validation Fingerprint");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbSendPaymentEmail']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbSendPaymentEmail']")).click();
            Reporter.log("Select The Option Send Payment Email");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbVerifyRadiologyPatientFingerprint']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbVerifyRadiologyPatientFingerprint']")).click();
            Reporter.log("Select The Option Verify Radiology Patient Fingerprint");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbAutoGenerateRPWalkInAppointment']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbAutoGenerateRPWalkInAppointment']")).click();
            Reporter.log("Select The Option Auto Generate Radiology Procedure Walk-In Appt");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbSendCreditInvoiceEmail']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbSendCreditInvoiceEmail']")).click();
            Reporter.log("Select The Option Send Credit Invoice Email");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbSendPaymentSMS']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbSendPaymentSMS']")).click();
            Reporter.log("Select The Option Send Payment SMS");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbShowBirthdate']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbShowBirthdate']")).click();
            Reporter.log("Select The Option Show Birthdate");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbShowScanHIDCard']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbShowScanHIDCard']")).click();
            Reporter.log("Select The Option Show Scan HID Card");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbIsBirthdateRequired']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbIsBirthdateRequired']")).click();
            Reporter.log("Select The Option Is Birthdate Required");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbAddSymptomToVisit']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbAddSymptomToVisit']")).click();
            Reporter.log("Select The Option Add Symptom To Visit");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbIsPatientMobileRequired']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbIsPatientMobileRequired']")).click();
            Reporter.log("Select The Option Is Patient Mobile Required");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbShowBloodGroup']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbShowBloodGroup']")).click();
            Reporter.log("Select The Option Show Blood Group");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbShowWorldScan']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbShowWorldScan']")).click();
            Reporter.log("Select The Option  Show World Scan");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbIsTestQuestionRequired']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbIsTestQuestionRequired']")).click();
            Reporter.log("Select The Option Is Test Question Required ");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbSendLabResultSMS']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbSendLabResultSMS']")).click();
            Reporter.log("Select The Option Send Lab Result SMS");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbIsSharedPatient']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbIsSharedPatient']")).click();
            Reporter.log("Select The Option Is Shared Patients");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbMobileNotification']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbMobileNotification']")).click();
            Reporter.log("Select The Option Send Result Mobile Notification");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbAllowPrintPdfBarcode']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbAllowPrintPdfBarcode']")).click();
            Reporter.log("Select The Option Allow Print Pdf Barcode");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbSendBirthDaySMS']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbSendBirthDaySMS']")).click();
            Reporter.log("Select The Option Send Birthday SMS ");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbIsPreAnalyticalRequired']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbIsPreAnalyticalRequired']")).click();
            Reporter.log("Select The Option Is Pre Analytical Required");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbMidName2']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbMidName2']")).click();
            Reporter.log("Select The Option Patient Middle Name");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbUseDefaultCity']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbUseDefaultCity']")).click();
            Reporter.log("Select The Option Use Default City");

        }
        if (!OpenDriver.findElement(By.cssSelector("input[id$='cbIsPatientCountryRequired']")).isSelected()) {
            OpenDriver.findElement(By.cssSelector("input[id$='cbIsPatientCountryRequired']")).click();
            Reporter.log("Select The Option Is Patient Country Required");

        } else {
            System.out.println("All Options selected in the page ");
        }
        clickOnSaveButton(OpenDriver);
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
