package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/3/2019 4:25 PM
 **/
public class BodySystem extends BasePage {
    WebDriver browser;
    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToBodySystem() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", BodySystemPageID, browser, "Click on Body System link Page ");
        assertByPageName("Body Systems");
    }

    String RandomString = generateString();
    String Name = "BodySystemName" + RandomString;

    @Test(priority = 2)
    public void addBodySystem() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", BodySystemPageID, browser, "Click on Body System link Page ");
        clickOnAddButton(browser);
        senKeys("id", "ctl00_ContentPlaceHolder1_txtBodySystemName", Name, browser, "Fill Body System Name");
        senKeys("cssselector", "textarea[id*='txtDefaultRosValue']", "Default ROS Value" + Name, browser, "Fill Default ROS Value");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addBodySystem")
    public void editBodySystem() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", BodySystemPageID, browser, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, browser, "Search By Name" + Name);
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    String BodySystemPartName = "BodySystemName" + RandomString;

    @Test(priority = 4, dependsOnMethods = "addBodySystem")
    public void addBodySystemPartList() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", BodySystemPageID, browser, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, browser, "Search By Name" + Name);
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        click("cssselector", "a[id*='ibtnAddBodyPart']", browser, "Click on Add Body Part Button");
        senKeys("cssselector", "input[id*='txtBodySystemPartName']", BodySystemPartName, browser, "Fill BodySystemPartName");
        senKeys("id", "ctl00_ContentPlaceHolder1_txtBodySystemPartDescription", "Automated Description", browser, "Fill Description");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 5, dependsOnMethods = {"addBodySystem", "addBodySystemPartList"})
    public void deleteBodySystemPartList() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", BodySystemPageID, browser, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, browser, "Search By Name" + Name);
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        scrollDown(browser);
        scrollDown(browser);
        Thread.sleep(1000);
        click("cssselector", "input[name*='gvBodySystemPartItem']", browser, "Click on the CheckBox to Delete");
        click("id", "ctl00_ContentPlaceHolder1_ibtnDeleteBodyPart", browser, "Click on Delete Button");
        acceptTheWebPageAlert(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 6, dependsOnMethods = "addBodySystem")
    public void deleteBodySystem() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", BodySystemPageID, browser, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, browser, "Search By Name" + Name);
        clickOnSearchButton(browser);
        click("cssselector", "input[name*='grdBodySystemItem']", browser, "Click on the CheckBox to Delete");
        clickOnDeleteButton(browser);
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
