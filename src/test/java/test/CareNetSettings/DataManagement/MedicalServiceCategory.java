package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;


/**
 * Created By R.Alshawabkeh 12/3/2019 4:29 PM
 **/

public class MedicalServiceCategory extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test
    public void navigateToMedicalServiceCategory() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", MedicalServiceCategoryPageID, browser,"Click on Medical Service Category Page Link");
        assertByPageName("Medical Service Category");
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
