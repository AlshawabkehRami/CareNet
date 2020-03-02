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
    WebDriver browser;


    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToRoomsCategories() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomsCategoriesPageID, browser, "Click on Rooms Categories Page Link");
        assertByPageName("Rooms Categories");
    }

    String RandomString = generateString();
    String CategoryName = "Category Name" + RandomString;

    @Test(priority = 2)
    public void addRoomsCategories() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomsCategoriesPageID, browser, "Click on Rooms Categories Page Link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='txtRoomCategoryName']", CategoryName, browser, "Fill Category Name ");
        senKeys("cssselector", "input[id$='txtRoomCategoryName2']", CategoryName, browser, "Fill Category Name2 ");
        DDLByIndex("select[id$='ddlRoomType']", 1, browser);
        senKeys("cssselector", "input[id$='txtRoomColor']", "Color", browser, "Fill Category Color ");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();


    }

    @Test(priority = 3, dependsOnMethods = "addRoomsCategories")
    public void editRoomsCategories() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomsCategoriesPageID, browser, "Click on Rooms Categories Page Link");
        senKeys("cssselector", "input[id$='txtNameRomCategoryName']", CategoryName, browser, "Search By Category Name ");
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnUpdateButton(browser);
        assertOperationDoneSuccessfully();
    }

    @Test(priority = 4, dependsOnMethods = "addRoomsCategories")
    public void deleteRoomsCategories() throws InterruptedException {
        URLnavigation(browser);
        adminLogin(browser);
        NavigateToRoomsManagementLink(browser);
        click("id", RoomsCategoriesPageID, browser, "Click on Rooms Categories Page Link");
        senKeys("cssselector", "input[id$='txtNameRomCategoryName']", CategoryName, browser, "Search By Category Name ");
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='grdSymptomsItem']", browser, "Click on the CheckBox for delete");
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
