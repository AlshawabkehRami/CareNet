package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/4/2019 9:10 AM
 **/
public class KnowledgeBase extends BasePage {
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test
    public void navigateToKnowledgeBase() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", KnowledgeBasePageID, browser, "Click on KnowledgeBase page link");
        assertByPageName("Knowledge Base");
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
