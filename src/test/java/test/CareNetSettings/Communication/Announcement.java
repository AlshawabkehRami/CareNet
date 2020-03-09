package test.CareNetSettings.Communication;

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
 * Created By R.Alshawabkeh 1/22/2020 2:18 PM
 **/

public class Announcement extends BasePage {

    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser = theBrowser();
    }

    @Test(priority = 1)
    public void navigateToAnnouncement() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        communicationLinkNavigation(browser);
        click("id", AnnouncementPageID, browser, "Click on Announcement  Page link ");
        assertByPageName("Announcementpage");
    }

    @Test(priority = 2)
    public void addAnnouncement() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        communicationLinkNavigation(browser);
        click("id", AnnouncementPageID, browser, "Click on Announcement  Page link ");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtAnnouncementTitle']", "Title", browser, "Fill the title ");
        TodayDate("img[id$='AnnouncementDate_imgFrom']", "div[id$='AnnouncementDate_ext_today']", browser);
        senKeys("cssselector", "input[id$='tbTime']", "10", browser, "Fill the Time ");
        senKeys("cssselector", "input[id$='txtAnnouncementName']", "Announcement", browser, "Fill the Announcement ");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();

    }

/*    @Test(priority = 3, dependsOnMethods = "addAnnouncement")

    public void editAnnouncement() {
    }

 *//*   @AfterMethod
    public void tearDown(ITestResult result, Method method) {
        if (!result.isSuccess()) {
            screenShot(browser, result, method.getName());
        }
        browser.quit();
        Reporter.log("Closing The Browser");
    }*/
}
