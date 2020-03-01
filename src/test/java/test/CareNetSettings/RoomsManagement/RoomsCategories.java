package test.CareNetSettings.RoomsManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 1/21/2020 4:18 PM
 **/

public class RoomsCategories extends BasePage {
    WebDriver driver;
    WebDriver OpenDriver;
    String PageLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_rptForms_ctl02_lblfontFrm";


    @BeforeMethod
    public void setUp() {
        OpenDriver = driverType(driver, "chrome");
    }

    @Test(priority = 1)
    public void navigateToRoomsCategories() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Rooms Categories Page Link");
        assertByPageName("Rooms Categories");
    }

    String RandomString = generateString();
    String CategoryName = "Category Name" + RandomString;

    @Test(priority = 2)
    public void addRoomsCategories() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Rooms Categories Page Link");
        clickOnAddButton(OpenDriver);
        senKeys("cssselector", "input[id$='txtRoomCategoryName']", CategoryName, OpenDriver, "Fill Category Name ");
        senKeys("cssselector", "input[id$='txtRoomCategoryName2']", CategoryName, OpenDriver, "Fill Category Name2 ");
        DDLByIndex("select[id$='ddlRoomType']", 1, OpenDriver);
        senKeys("cssselector", "input[id$='txtRoomColor']", "Color", OpenDriver, "Fill Category Color ");
        clickOnSaveButton(OpenDriver);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3, dependsOnMethods = "addRoomsCategories")
    public void editRoomsCategories() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Rooms Categories Page Link");
        senKeys("cssselector", "input[id$='txtNameRomCategoryName']", CategoryName, OpenDriver, "Search By Category Name ");
        clickOnSearchButton(OpenDriver);
        clickOnTheRowTable(OpenDriver);
        clickOnUpdateButton(OpenDriver);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addRoomsCategories")
    public void deleteRoomsCategories() throws InterruptedException {
        navigateToUrl(OpenDriver);
        loginWithAdminUser(OpenDriver);
        NavigateToRoomsManagementLink(OpenDriver);
        click("id", PageLinkLocator, OpenDriver, "Click on Rooms Categories Page Link");
        senKeys("cssselector", "input[id$='txtNameRomCategoryName']", CategoryName, OpenDriver, "Search By Category Name ");
        clickOnSearchButton(OpenDriver);
        click("cssselector", "input[name$='grdSymptomsItem']", OpenDriver, "Click on the CheckBox for delete");
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
