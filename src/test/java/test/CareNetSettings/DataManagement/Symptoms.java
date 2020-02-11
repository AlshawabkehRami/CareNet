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

public class Symptoms extends BasePage {
    WebDriver driver;
    public static WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl00_lblfontFrm";

    @BeforeMethod
    public void setUp(Method method) {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToSymptomsPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Symptoms Page Link");
        Wait = new WebDriverWait(OpenDriver, 20);
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_ContentPlaceHolder1_lblSearchArea"))).getText();
        String ExpectedResult = "Search";
        Assert.assertEquals(ExpectedResult, ActualResult, "Symptoms Page not opened Properly");

    }

    String SymptomName1 = generateString();
    String SymptomName2 = "SymptomName" + SymptomName1;

    @Test(priority = 2, dependsOnMethods = "navigateToSymptomsPage")
    public void addSymptoms() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Symptoms Page Link");
        click("cssselector", "a[id*='ibtnAdd']", OpenDriver, "Click on Add button");
        senKeys("cssselector", "input[id*='txtSymptomName']", SymptomName2, OpenDriver, "Fill Symptom Name");
        DDL("ctl00$ContentPlaceHolder1$ddlSymptomGroup", "Allergic", OpenDriver);
        DDL("ctl00$ContentPlaceHolder1$ddlGender", "Both", OpenDriver);
        click("cssselector", "input[id*='btnSave']", OpenDriver, "Click on Save Button");
        String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("info_message"))).getText();
        String ExpectedResult1 = "x\n" +
                "Operation Done Successfully .";
        Assert.assertEquals(ActualResult1, ExpectedResult1, "Operation Done Successfully .");
    }

    @Test(priority = 3, dependsOnMethods = "addSymptoms")
    public void editSymptoms() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Symptoms Page Link");
        senKeys("cssselector", "input[id*='txtName']", SymptomName2, OpenDriver, "Enter Symptom Name");
        click("cssselector", "input[id*='btnShowAll']", OpenDriver, "Click on Search Button");
        click("xpath","//table/tbody/tr[2]",OpenDriver,"Click on the Row");
        click("cssselector","input[id*='btnUpdate']",OpenDriver,"Click on update Button");
        String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("info_message"))).getText();
        String ExpectedResult1 = "x\n" +
                "Operation Done Successfully .";
        Assert.assertEquals(ActualResult1, ExpectedResult1, "Operation Done Successfully .");

    }
    @Test(priority = 4, dependsOnMethods = "addSymptoms")
    public void deleteSymptoms() throws InterruptedException {
        navigateToUrl(OpenDriver);
        LoginWithAdminUser(OpenDriver);
        NavigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Symptoms Page Link");
        senKeys("cssselector", "input[id*='txtName']", SymptomName2, OpenDriver, "Enter Symptom Name");
        click("cssselector", "input[id*='btnShowAll']", OpenDriver, "Click on Search Button");
        click("cssselector", "input[name*='grdSymptomsItem']", OpenDriver, "Click on The checkbos to delete");
        click("cssselector", "a[id*='ibtnDelete']", OpenDriver, "Click on delete Icon");
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



