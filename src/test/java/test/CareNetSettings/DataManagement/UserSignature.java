package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/3/2019 4:35 PM
 **/

public class UserSignature extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl08_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToUserSignature() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on User Signature Link Page ");
        assertByPageName("Users Signatures");
    }

    String ImagePath = "C:\\Users\\r.alshawabkeh\\IdeaProjects\\Second_Project\\testIamge.png";

    @Test(priority = 2, dependsOnMethods = "navigateToUserSignature")
    public void addUserSignature() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on User Signature Link Page ");
        clickOnAddButton(OpenDriver);
        Thread.sleep(2000);
        autoSuggest("img[id*='sggEmployee2_imgSearch']", "div[id*='sggEmployee2_dvSuggestions']", OpenDriver);
        Thread.sleep(1000);
        OpenDriver.findElement(By.id("ctl00_ContentPlaceHolder1_fileUpload")).sendKeys(ImagePath);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addUserSignature")
    public void deleteUserSignature() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on User Signature Link Page ");
        autoSuggest("img[id*='sggEmployee_imgSearch']", "div[id*='dvSuggestions']", OpenDriver);
        clickOnSearchButton(OpenDriver);
        click("cssselector", "a[id*='ibtnDeleteFile']", OpenDriver, "Click on Delete Button");
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
