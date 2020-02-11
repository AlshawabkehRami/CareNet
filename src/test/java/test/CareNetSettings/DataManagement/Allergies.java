package test.CareNetSettings.DataManagement;

import Driver.BasePage;
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
 * C@BeforeMethod
 * public void setUp() {
 * OpenDriver = driverType(driver, "chrome");
 * }reated By R.Alshawabkeh 12/3/2019 4:20 PM
 **/
public class Allergies extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;

    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl02_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToAllergiesPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Allergies Page Link");
        Wait = new WebDriverWait(OpenDriver, 20);
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_ContentPlaceHolder1_lblSearchArea"))).getText();
        String ExpectedResult = "Search";
        Assert.assertEquals(ActualResult, ExpectedResult, "Allergies Page not opened Properly");
    }

    String RandomString = generateString();
    String AllergiesName = "AllergiesName" + RandomString;

    @Test(priority = 2)
    public void addAllergies() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Allergies Page Link");
        click("cssselector", "a[id*='ibtnAdd']", OpenDriver, "Click on Add button");
        senKeys("cssselector", "input[id*='txtAllergyName']", AllergiesName, OpenDriver, "Fill ");
        DDL("ctl00$ContentPlaceHolder1$ddlAllergyType", "Food Allergy", OpenDriver);
        click("cssselector", "input[id*='btnSave']", OpenDriver, "Click on Save button");
        String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("info_message"))).getText();
        String ExpectedResult1 = "x\n" +
                "Operation Done Successfully .";
        Assert.assertEquals(ActualResult1, ExpectedResult1, "Operation Done Successfully .");
    }

    @Test(priority = 3, dependsOnMethods = "addAllergies")
    public void editAllergies() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Allergies Page Link");
        senKeys("cssselector", "input[id*='txtName']", AllergiesName, OpenDriver, "Fill Search field with");
        click("cssselector", "input[id*='btnShowAll']", OpenDriver, "Click on the Search button");
        click("xpath", "//table/tbody/tr[2]", OpenDriver, "click on the Row");
        click("cssselector", "input[id*='btnUpdate']", OpenDriver, "Click on the Update Button");
        String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("info_message"))).getText();
        String ExpectedResult1 = "x\n" +
                "Operation Done Successfully .";
        Assert.assertEquals(ActualResult1, ExpectedResult1, "Operation Done Successfully .");


    }

    @Test(priority = 4, dependsOnMethods = "addAllergies")
    public void deleteAllergies() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Allergies Page Link");
        senKeys("cssselector", "input[id*='txtName']", AllergiesName, OpenDriver, "Fill Search field with");
        click("cssselector", "input[id*='btnShowAll']", OpenDriver, "Click on the Search button");
        click("cssselector", "input[name*='grdAllergiesItem']", OpenDriver, "Clicko on CheckBox to delete");
        click("cssselector", "a[id*='ibtnDelete']", OpenDriver, "Click on Delete Button");
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
