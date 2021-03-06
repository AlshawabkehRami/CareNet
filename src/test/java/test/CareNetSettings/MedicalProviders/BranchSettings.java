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
    WebDriver browser;


    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

        @Test(priority = 1)

        public void navigateToBranchSettings() throws InterruptedException {
            URLnavigation(browser);
            adminLogin(browser);
            medicalProvidersLinkNavigation(browser);
            click("id", BranchSettingsPageID, browser, "Click on Branch Settings Page Link");
            assertByPageName("Branch Settings");
        }
    @Test(priority = 2)
    public void checkAllOptionsInBranchSettings() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        medicalProvidersLinkNavigation(browser);
        click("id", BranchSettingsPageID, browser, "Click on Branch Settings Page Link");
        Thread.sleep(2000);
        if (!browser.findElement(By.cssSelector("input[id$='cbIsIdentityNoRequired']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbIsIdentityNoRequired']")).click();
            Reporter.log("Select The Option Is Identity No Required");
        }
        if (!browser.findElement(By.cssSelector("input[id$='cbMaritalStatus']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbMaritalStatus']")).click();
            Reporter.log("Select The Option Show Marital Status");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbShowAddressInfoHint']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbShowAddressInfoHint']")).click();
            Reporter.log("Select The Option Show Address Info Hint");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbLastName2']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbLastName2']")).click();
            Reporter.log("Select The Option Patient Third Name");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbEnableResultValidationFingerprint']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbEnableResultValidationFingerprint']")).click();
            Reporter.log("Select The Option Enable Result Validation Fingerprint");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbSendPaymentEmail']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbSendPaymentEmail']")).click();
            Reporter.log("Select The Option Send Payment Email");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbVerifyRadiologyPatientFingerprint']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbVerifyRadiologyPatientFingerprint']")).click();
            Reporter.log("Select The Option Verify Radiology Patient Fingerprint");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbAutoGenerateRPWalkInAppointment']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbAutoGenerateRPWalkInAppointment']")).click();
            Reporter.log("Select The Option Auto Generate Radiology Procedure Walk-In Appt");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbSendCreditInvoiceEmail']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbSendCreditInvoiceEmail']")).click();
            Reporter.log("Select The Option Send Credit Invoice Email");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbSendPaymentSMS']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbSendPaymentSMS']")).click();
            Reporter.log("Select The Option Send Payment SMS");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbShowBirthdate']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbShowBirthdate']")).click();
            Reporter.log("Select The Option Show Birthdate");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbShowScanHIDCard']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbShowScanHIDCard']")).click();
            Reporter.log("Select The Option Show Scan HID Card");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbIsBirthdateRequired']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbIsBirthdateRequired']")).click();
            Reporter.log("Select The Option Is Birthdate Required");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbAddSymptomToVisit']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbAddSymptomToVisit']")).click();
            Reporter.log("Select The Option Add Symptom To Visit");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbIsPatientMobileRequired']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbIsPatientMobileRequired']")).click();
            Reporter.log("Select The Option Is Patient Mobile Required");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbShowBloodGroup']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbShowBloodGroup']")).click();
            Reporter.log("Select The Option Show Blood Group");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbShowWorldScan']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbShowWorldScan']")).click();
            Reporter.log("Select The Option  Show World Scan");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbIsTestQuestionRequired']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbIsTestQuestionRequired']")).click();
            Reporter.log("Select The Option Is Test Question Required ");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbSendLabResultSMS']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbSendLabResultSMS']")).click();
            Reporter.log("Select The Option Send Lab Result SMS");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbIsSharedPatient']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbIsSharedPatient']")).click();
            Reporter.log("Select The Option Is Shared Patients");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbMobileNotification']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbMobileNotification']")).click();
            Reporter.log("Select The Option Send Result Mobile Notification");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbAllowPrintPdfBarcode']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbAllowPrintPdfBarcode']")).click();
            Reporter.log("Select The Option Allow Print Pdf Barcode");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbSendBirthDaySMS']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbSendBirthDaySMS']")).click();
            Reporter.log("Select The Option Send Birthday SMS ");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbIsPreAnalyticalRequired']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbIsPreAnalyticalRequired']")).click();
            Reporter.log("Select The Option Is Pre Analytical Required");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbMidName2']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbMidName2']")).click();
            Reporter.log("Select The Option Patient Middle Name");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbUseDefaultCity']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbUseDefaultCity']")).click();
            Reporter.log("Select The Option Use Default City");

        }
        if (!browser.findElement(By.cssSelector("input[id$='cbIsPatientCountryRequired']")).isSelected()) {
            browser.findElement(By.cssSelector("input[id$='cbIsPatientCountryRequired']")).click();
            Reporter.log("Select The Option Is Patient Country Required");

        } else {
            System.out.println("All Options selected in the page ");
        }
        clickOnSaveButton(browser);
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
