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
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToUserSignature() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", UserSignaturePageID, browser, "Click on User Signature Link Page ");
        assertByPageName("Users Signatures");
    }

    String ImagePath = "C:\\Users\\r.alshawabkeh\\IdeaProjects\\Second_Project\\testIamge.png";

    @Test(priority = 2, dependsOnMethods = "navigateToUserSignature")
    public void addUserSignature() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", UserSignaturePageID, browser, "Click on User Signature Link Page ");
        clickOnAddButton(browser);
        Thread.sleep(2000);
        autoSuggest("img[id*='sggEmployee2_imgSearch']", "div[id*='sggEmployee2_dvSuggestions']", browser);
        Thread.sleep(1000);
        browser.findElement(By.id("ctl00_ContentPlaceHolder1_fileUpload")).sendKeys(ImagePath);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addUserSignature")
    public void deleteUserSignature() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", UserSignaturePageID, browser, "Click on User Signature Link Page ");
        autoSuggest("img[id*='sggEmployee_imgSearch']", "div[id*='dvSuggestions']", browser);
        clickOnSearchButton(browser);
        click("cssselector", "a[id*='ibtnDeleteFile']", browser, "Click on Delete Button");
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
