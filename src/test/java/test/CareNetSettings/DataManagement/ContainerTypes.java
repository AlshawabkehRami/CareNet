package test.CareNetSettings.DataManagement;
import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.lang.reflect.Method;

/**
 * Created By R.Alshawabkeh 12/3/2019 4:39 PM
 **/
public class ContainerTypes extends BasePage {
    WebDriver browser;
    @BeforeMethod
    public void setUp() {
        browser=theBrowser();

    }
    @Test(priority = 1)
    public void navigateToContainerTypes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", ContainerTypesPageID, browser, "Click on Container Types Page Link");
        assertByPageName("Container Types");

    }
    String RandomString = generateString();
    String ContainerTypeName = "Container Type Name" + RandomString;
    @Test(priority = 2, dependsOnMethods = "navigateToContainerTypes")
    public void addContainerTypes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", ContainerTypesPageID, browser, "Click on Container Types Page Link");
        clickOnSearchButton(browser);
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id$='ContainerTypeName']", ContainerTypeName, browser, "Fill Container Type Name");
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 3, dependsOnMethods = "addContainerTypes")
    public void editContainerTypes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", ContainerTypesPageID, browser, "Click on Container Types Page Link");
        senKeys("cssselector", "input[id$='txtName']", ContainerTypeName, browser, "Fill Search Field With :: " + ContainerTypeName);
        clickOnSearchButton(browser);
        clickOnTheRowTable(browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();
    }
    @Test(priority = 4, dependsOnMethods = "addContainerTypes")
    public void deleteContainerTypes() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", ContainerTypesPageID, browser, "Click on Container Types Page Link");
        senKeys("cssselector", "input[id$='txtName']", ContainerTypeName, browser, "Fill Search Field With :: " + ContainerTypeName);
        clickOnSearchButton(browser);
        click("cssselector", "input[name$='gvContainerTypesItem']", browser, "Click on the CheckBox for Delete");
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
