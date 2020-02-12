package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_ContentPlaceHolder1_lblSearchArea"))).getText();
        String ExpectedResult = "Search";
        Assert.assertEquals(ActualResult, ExpectedResult, "Body Systems Page not opened Properly");
    }

    String RandomString = generateString();
    String Name = "BodySystemName" + RandomString;

    @Test(priority = 2)
    public void addBodySystem() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        click("cssselector", "a[id*='ibtnAdd']", OpenDriver, "Click on Add button");
        senKeys("id", "ctl00_ContentPlaceHolder1_txtBodySystemName", Name, OpenDriver, "Fill Body System Name");
        senKeys("cssselector", "textarea[id*='txtDefaultRosValue']", "Default ROS Value" + Name, OpenDriver, "Fill Default ROS Value");
        click("cssselector", "input[id*='btnSave']", OpenDriver, "Click on the Save button");
        String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("info_message"))).getText();
        String ExpectedResult1 = "x\n" +
                "Operation Done Successfully .";
        Assert.assertEquals(ActualResult1, ExpectedResult1, "Operation Done Successfully .");
    }

    @Test(priority = 3, dependsOnMethods = "addBodySystem")
    public void editBodySystem() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, OpenDriver, "Search By Name" + Name);
        click("cssselector", "input[id*='btnSearch']", OpenDriver, "Click on Search Button");
        click("xpath", "//table/tbody/tr[2]", OpenDriver, "Click on The Row");
        click("cssselector", "input[id*='btnUpdate']", OpenDriver, "Click on Update Button");
        String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("info_message"))).getText();
        String ExpectedResult1 = "x\n" +
                "Operation Done Successfully .";
        Assert.assertEquals(ActualResult1, ExpectedResult1, "Operation Done Successfully .");

    }

    @Test(priority = 4, dependsOnMethods = "addBodySystem")
    public void addBodySystemPartList() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, OpenDriver, "Search By Name" + Name);
        click("cssselector", "input[id*='btnSearch']", OpenDriver, "Click on Search Button");
        click("xpath", "//table/tbody/tr[2]", OpenDriver, "Click on The Row");
    }

    @Test(priority = 5, dependsOnMethods = "addBodySystem")
    public void editBodySystemPartList() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, OpenDriver, "Search By Name" + Name);
        click("cssselector", "input[id*='btnSearch']", OpenDriver, "Click on Search Button");
        click("xpath", "//table/tbody/tr[2]", OpenDriver, "Click on The Row");
    }

    @Test(priority = 6, dependsOnMethods = "addBodySystem")
    public void deleteBodySystemPartList() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, OpenDriver, "Search By Name" + Name);
        click("cssselector", "input[id*='btnSearch']", OpenDriver, "Click on Search Button");
        click("xpath", "//table/tbody/tr[2]", OpenDriver, "Click on The Row");
    }

    @Test(priority = 7, dependsOnMethods = "addBodySystem")
    public void deleteBodySystem() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Body System link Page ");
        senKeys("cssselector", "input[id*='txtBodySystemNameSearch']", Name, OpenDriver, "Search By Name" + Name);
        click("cssselector", "input[id*='btnSearch']", OpenDriver, "Click on Search Button");
        click("cssselector", "input[name*='grdBodySystemItem']", OpenDriver, "Click on the CheckBox to Delete");
        click("cssselector", "a[id*='ibtnDelete']", OpenDriver, "");
        OpenDriver.switchTo().alert().accept();
        Reporter.log("Accept the WebPage Alert");
        String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("info_message"))).getText();
        String ExpectedResult1 = "x\n" +
                "Operation Done Successfully .";
        Assert.assertEquals(ActualResult1, ExpectedResult1, "Operation Done Successfully .");


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
