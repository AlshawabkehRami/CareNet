package test.CareNetSettings.Agreements;

import Driver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/21/2020 4:46 PM
 **/

public class ExcludedServicesAndDiseases extends BasePage {

    WebDriver browser;


    @BeforeMethod
    public void setUp() {
        browser = theBrowser();
    }

    @Test
    public void navigateToExcludedServicesAndDiseases() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        agreementsLinknavigation(browser);
        click("id", ExcludedServicesAndDiseasesPageID, browser, "Click on  Excluded Services And Diseases Page Link");
        assertByPageName("Excluded Services & Diseases");


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
