package test.CareNetSettings.DataManagement;

import Driver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;


/**
 * Created By R.Alshawabkeh 12/3/2019 4:02 PM
 **/

public class Diseases extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl01_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToDiseasesPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Diseases page link");
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_ContentPlaceHolder1_lblSearchArea"))).getText();
        String ExpectedResult = "Search";
        Assert.assertEquals(ActualResult, ExpectedResult, "Diseases Page not opened Properly");

    }

    String RandomString = generateString();
    String DiseasesName = "DiseasesName" + RandomString;

    @Test(priority = 2)
    public void addDiseases() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Diseases page link");
        click("cssselector", "a[id*='ibtnAdd']", OpenDriver, "Click on Add button");
        senKeys("cssselector", "input[id*='txtDiseaseName']", DiseasesName, OpenDriver, "Fill Disease Name");
        DDL("ctl00$ContentPlaceHolder1$ddlCodingSystem", "Not Standard", OpenDriver);
        senKeys("id", "ctl00_ContentPlaceHolder1_txtCode", "Code" + RandomString, OpenDriver, "Fill The Code");
        senKeys("cssselector", "input[id*='txtIcdCode']", "ICD Code" + RandomString, OpenDriver, "Fill The ICD Code");
        DDL("ctl00$ContentPlaceHolder1$ddlGender", "Both", OpenDriver);
        senKeys("cssselector", "input[id*='txtAgeFrom']", "18", OpenDriver, "Fill Age From");
        senKeys("cssselector", "input[id*='txtAgeTo']", "99", OpenDriver, "Fill Age From");
        senKeys("cssselector", "input[id*='txtDiseaseAlias']", "Disease Alias", OpenDriver, "Fill Disease Alias");
        senKeys("cssselector", "input[id*='txtFrequency']", "122" + RandomString, OpenDriver, "Fill The Frequency");
        click("cssselector", "input[id*='btnSave']", OpenDriver, "Click on Save Button");
        assertOperationDoneSuccessfully();



    }

    @Test(priority = 3, dependsOnMethods = "addDiseases")
    public void editDiseases() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Diseases page link");
        senKeys("cssselector", "input[id*='txtNameSearch']", DiseasesName, OpenDriver, "Search for the name of the disease" + DiseasesName);
        click("cssselector", "input[id*='btnSearch']", OpenDriver, "Click on Search Button");
        click("xpath", "//table/tbody/tr[2]", OpenDriver, "Click on the Disease Row ");
        click("cssselector", "input[id*='btnUpdate']", OpenDriver, "Click on Update Button");
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4,dependsOnMethods = "addDiseases")
    public void deletDiseases() throws InterruptedException {

        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Diseases page link");
        senKeys("cssselector", "input[id*='txtNameSearch']", DiseasesName, OpenDriver, "Search for the name of the disease" + DiseasesName);
        click("cssselector", "input[id*='btnSearch']", OpenDriver, "Click on Search Button");
        click("cssselector","input[name*='grdDiseasesItem']",OpenDriver,"Clicko on CheckBox to delete");
        click("cssselector", "a[id*='ibtnDelete']", OpenDriver, "Click on delete Icon");
        OpenDriver.switchTo().alert().accept();
        Reporter.log("Accept the WebPage Alert");
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
