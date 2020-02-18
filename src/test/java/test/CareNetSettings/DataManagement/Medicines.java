package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/3/2019 4:33 PM
 **/
public class Medicines extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl07_lblfontFrm";

    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToMedicinesPage() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medicines Link Page ");
        assertByPageName("Medicines");
    }

    String RandomString = generateString();
    String TradeName = "Trade Name" + generateString();

    @Test(priority = 2)
    public void addMedicines() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medicines Link Page ");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id*='txtCode']", "Code" + RandomString, OpenDriver, "Fill the Code");
        senKeys("cssselector", "input[id$='txtTradeName']", TradeName, OpenDriver, "Fill the Trade Name");
        autoSuggest("a[id*='lbtnImgSearch']", "div[id*='dvSuggestions']", OpenDriver);
        senKeys("cssselector", "input[id$='txtManufacturer']", "Manufacturer" + RandomString, OpenDriver, "Fill Manufacturer");
        senKeys("cssselector", "input[id*='txtTherapeuticUse']", "Therapeutic Use" + RandomString, OpenDriver, "Fill Therapeutic Use");
        senKeys("cssselector", "input[id*='txtConcentrationOfDrug']", "Con" + RandomString, OpenDriver, "Fill Concentration Of Drug ");
        DDLByIndex("select[id*='ddltDosageForm']", 2, OpenDriver);
        DDLByIndex("select[id*='ddlStatus']", 2, OpenDriver);
        TodayDate("img[id*='ucDeleteEffectiveDate']", "div[id*='ucDeleteEffectiveDate_ext_today']", OpenDriver);
        senKeys("cssselector", "input[id*='txtMedicineDose']", "Medicine Dose" + RandomString, OpenDriver, "Fill Medicine Dose");
        senKeys("cssselector", "input[id*='txtStrength']", "Strength" + RandomString, OpenDriver, "Fill Strength");
        DDLByIndex("select[id*='ddlServiceCategory']", 2, OpenDriver);
        senKeys("cssselector", "input[id*='txtStandardCode']", "Standard Code" + RandomString, OpenDriver, "Fill Standard Code");
        DDLByIndex("select[id*='ddlMedicineUnits']", 2, OpenDriver);
        Thread.sleep(3000);
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3, dependsOnMethods = "addMedicines")
    public void editMedicines() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medicines Link Page ");
        senKeys("cssselector", "input[id$='txtTradeNameSearch']", TradeName, OpenDriver, "Search By Trade Name ");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4, dependsOnMethods = "addMedicines")
    public void deleteMedicines() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        navigateToDataManagmentLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Medicines Link Page ");
        senKeys("cssselector", "input[id$='txtTradeNameSearch']", TradeName, OpenDriver, "Search By Trade Name ");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name*='grdMedicinesItem']", OpenDriver, "Click on the CheckBox to delete");
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
