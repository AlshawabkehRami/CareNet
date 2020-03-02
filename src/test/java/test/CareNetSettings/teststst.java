package test.CareNetSettings;

import Driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created By R.Alshawabkeh 3/2/2020 11:29 AM
 **/

public class teststst extends BasePage {

    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser=theBrowser();
    }

    @Test(priority = 1)
    public void navigateToAllergiesPage() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
      //  click("id", navigateToAllergiesPage, browser, "Click on Allergies Page Link");
        assertByPageName("Allergies");
    }
 /*   String RandomString = generateString();
    String AllergiesName = "AllergiesName" + RandomString;

    @Test(priority = 2)
    public void addAllergies() throws InterruptedException {
        navigateToUrl(browser);
        loginWithAdminUser(browser);
        navigateToDataManagmentLink(browser);
        click("id", PageLinkLocator, browser, "Click on Allergies Page Link");
        clickOnAddButton(browser);
        senKeys("cssselector", "input[id*='txtAllergyName']", AllergiesName, browser, "Fill ");
        DDLByValue("ctl00$ContentPlaceHolder1$ddlAllergyType", "Food Allergy", browser);
        clickOnSaveButton(browser);
        assertOperationDoneSuccessfully();

    }*/


}
