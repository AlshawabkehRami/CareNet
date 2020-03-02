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
    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToMedicinesPage() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", MedicinesPageID, browser, "Click on Medicines Link Page ");
        assertByPageName("Medicines");
    }

    String RandomString = generateString();
    String TradeName = "Trade Name" + generateString();

    @Test(priority = 2)
    public void addMedicines() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", MedicinesPageID, browser, "Click on Medicines Link Page ");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id*='txtCode']", "Code" + RandomString, browser, "Fill the Code");
        senKeys("cssselector", "input[id$='txtTradeName']", TradeName, browser, "Fill the Trade Name");
        autoSuggest("a[id*='lbtnImgSearch']", "div[id*='dvSuggestions']", browser);
        senKeys("cssselector", "input[id$='txtManufacturer']", "Manufacturer" + RandomString, browser, "Fill Manufacturer");
        senKeys("cssselector", "input[id*='txtTherapeuticUse']", "Therapeutic Use" + RandomString, browser, "Fill Therapeutic Use");
        senKeys("cssselector", "input[id*='txtConcentrationOfDrug']", "Con" + RandomString, browser, "Fill Concentration Of Drug ");
        DDLByIndex("select[id*='ddltDosageForm']", 2, browser);
        DDLByIndex("select[id*='ddlStatus']", 2, browser);
        TodayDate("img[id*='ucDeleteEffectiveDate']", "div[id*='ucDeleteEffectiveDate_ext_today']", browser);
        senKeys("cssselector", "input[id*='txtMedicineDose']", "Medicine Dose" + RandomString, browser, "Fill Medicine Dose");
        senKeys("cssselector", "input[id*='txtStrength']", "Strength" + RandomString, browser, "Fill Strength");
        DDLByIndex("select[id*='ddlServiceCategory']", 2, browser);
        senKeys("cssselector", "input[id*='txtStandardCode']", "Standard Code" + RandomString, browser, "Fill Standard Code");
        DDLByIndex("select[id*='ddlMedicineUnits']", 2, browser);
        Thread.sleep(3000);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3, dependsOnMethods = "addMedicines")
    public void editMedicines() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", MedicinesPageID, browser, "Click on Medicines Link Page ");
        senKeys("cssselector", "input[id$='txtTradeNameSearch']", TradeName, browser, "Search By Trade Name ");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();

    }

    @Test(priority = 4, dependsOnMethods = "addMedicines")
    public void deleteMedicines() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        dataManagementLinkNavigation(browser);
        click("id", MedicinesPageID, browser, "Click on Medicines Link Page ");
        senKeys("cssselector", "input[id$='txtTradeNameSearch']", TradeName, browser, "Search By Trade Name ");
        clickOnSearchButton(browser);
        click("cssselector", "input[name*='grdMedicinesItem']", browser, "Click on the CheckBox to delete");
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
