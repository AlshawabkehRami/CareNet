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
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl04_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToBodySystem() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        assertByPageName("Body Systems");
    }

    String RandomString = generateString();
    String Name = "BodySystemName" + RandomString;

    @Test(priority = 2)
    public void addBodySystem() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        clickOnAddButton(OpenDriver);
        senKeys("id", "ctl00_ContentPlaceHolder1_txtBodySystemName", Name, OpenDriver, "Fill Body System Name");
        senKeys("cssselector", "textarea[id*='txtDefaultRosValue']", "Default ROS Value" + Name, OpenDriver, "Fill Default ROS Value");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 3, dependsOnMethods = "addBodySystem")
    public void editBodySystem() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, OpenDriver, "Search By Name" + Name);
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    String BodySystemPartName = "BodySystemName" + RandomString;

    @Test(priority = 4, dependsOnMethods = "addBodySystem")
    public void addBodySystemPartList() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, OpenDriver, "Search By Name" + Name);
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        click("cssselector", "a[id*='ibtnAddBodyPart']", OpenDriver, "Click on Add Body Part Button");
        senKeys("cssselector", "input[id*='txtBodySystemPartName']", BodySystemPartName, OpenDriver, "Fill BodySystemPartName");
        senKeys("id", "ctl00_ContentPlaceHolder1_txtBodySystemPartDescription", "Automated Description", OpenDriver, "Fill Description");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 5, dependsOnMethods = {"addBodySystem", "addBodySystemPartList"})
    public void deleteBodySystemPartList() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, OpenDriver, "Search By Name" + Name);
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        scrollDown(OpenDriver);
        scrollDown(OpenDriver);
        Thread.sleep(1000);
        click("cssselector", "input[name*='gvBodySystemPartItem']", OpenDriver, "Click on the CheckBox to Delete");
        click("id", "ctl00_ContentPlaceHolder1_ibtnDeleteBodyPart", OpenDriver, "Click on Delete Button");
        acceptTheWebPageAlert(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 6, dependsOnMethods = "addBodySystem")
    public void deleteBodySystem() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, OpenDriver, "Search By Name" + Name);
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name*='grdBodySystemItem']", OpenDriver, "Click on the CheckBox to Delete");
        clickOnDeleteButton(OpenDriver);
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
