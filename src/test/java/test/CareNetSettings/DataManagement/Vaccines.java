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
 * Created By R.Alshawabkeh 12/3/2019 4:23 PM
 **/

public class Vaccines extends BasePage {

    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl03_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");

    }

    @Test(priority = 1)
    public void navigateToVaccinesPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Vaccines Link Page");
        Wait = new WebDriverWait(OpenDriver, 20);
        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_ContentPlaceHolder1_lblSearchArea"))).getText();
        String ExpectedResult = "Search";
        Assert.assertEquals(ActualResult, ExpectedResult, "Vaccines Page not opened Properly");

    }

    String RandomString = generateString();
    String VaccinesName = "VaccinesName" + RandomString;

    @Test(priority = 2)
    public void addVaccines() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Vaccines Link Page");
        click("cssselector", "a[id*='ibtnAdd']", OpenDriver, "Click on Add button");
        senKeys("cssselector", "input[id*='txtVaccineName']", VaccinesName, OpenDriver, "Fill Vaccine Name");
        click("cssselector", "input[id*='btnSave']", OpenDriver, "Click on Save Button");
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3,dependsOnMethods = "addVaccines")
    public void editVaccines() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Vaccines Link Page");
        senKeys("cssselector","input[id*='txtName']",VaccinesName,OpenDriver,"Search By Vaccines Name "+VaccinesName);
        click("cssselector","input[id*='btnShowAll']",OpenDriver,"Click on Show All Button");
        click("xpath","//table/tbody/tr[2]",OpenDriver,"Click on the Row");
        click("cssselector","input[id*='btnUpdate']",OpenDriver,"Click on update Button");
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 4,dependsOnMethods = "addVaccines")
    public void deleteVaccines() throws InterruptedException {

        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Vaccines Link Page");
        senKeys("cssselector","input[id*='txtName']",VaccinesName,OpenDriver,"Search By Vaccines Name "+VaccinesName);
        click("cssselector","input[id*='btnShowAll']",OpenDriver,"Click on Show All Button");
        click("cssselector","input[name*='grdVaccinesItem']",OpenDriver,"Click on checkBox to delete");
        click("cssselector","a[id*='ibtnDelete']",OpenDriver,"Click on Delete Button");
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
