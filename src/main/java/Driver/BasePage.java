package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BasePage {
    public static WebDriverWait Wait;
    public static WebDriver driver;
    String Url = "http://webserver/CarenetApps/QA/4.3/MySql/GlobalLanding/Login/GUI/FrmLogin.aspx";

    public static WebDriver driverType(WebDriver driver, String browser) {
        browser = browser.toLowerCase();
        switch (browser) {
            case "chrome":
                Reporter.log("Screenshot Capture in TestNG Results Started");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                Reporter.log("ChromeDriver is Opened And Maximized ");
                break;
            case "fireFox":
                Reporter.log("Screenshot Capture in TestNG Results Started");
                WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                Reporter.log("FireFox is Opened And Maximized ");
                break;


        }

        return driver;
    }

    public static void quit(WebDriver driver) {

        driver.quit();
        System.out.println("Closing the browser.");
        Reporter.log("Closing The Browser");
    }

    public static WebElement senKeys(String locatorType, String locator, String Value, WebDriver driver, String StepDescription) {
        Wait = new WebDriverWait(driver, 10);

        WebElement elem = null;
        locatorType = locatorType.toLowerCase();
        switch (locatorType) {
            case "id":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator))).sendKeys(Value);
                Reporter.log(StepDescription);
                break;
            case "name":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator))).sendKeys(Value);
                Reporter.log(StepDescription);

                break;
            case "xpath":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).sendKeys(Value);
                Reporter.log(StepDescription);

                break;
            case "class":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator))).sendKeys(Value);
                Reporter.log(StepDescription);

                break;
            case "linktext":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator))).sendKeys(Value);
                Reporter.log(StepDescription);

                break;
            case "partiallinktext":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator))).sendKeys(Value);
                Reporter.log(StepDescription);

                break;
            case "cssselector":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator))).sendKeys(Value);
                Reporter.log(StepDescription);

            default:
                break;
        }
        return elem;
    }


    public static WebElement click(String locatorType, String locator, WebDriver driver, String StepDescription) {
        Wait = new WebDriverWait(driver, 10);

        WebElement elem = null;
        locatorType = locatorType.toLowerCase();
        switch (locatorType) {
            case "id":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator))).click();
                Reporter.log(StepDescription);
                break;
            case "name":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator))).click();
                Reporter.log(StepDescription);
                break;
            case "xpath":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();
                Reporter.log(StepDescription);
                break;
            case "class":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator))).click();
                Reporter.log(StepDescription);
                break;
            case "linktext":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator))).click();
                Reporter.log(StepDescription);
                break;
            case "partiallinktext":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator))).click();
                Reporter.log(StepDescription);
                break;
            case "cssselector":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator))).click();
                Reporter.log(StepDescription);
            default:
                break;
        }
        return elem;
    }

    public WebElement waitVisibility(By by) {
        Wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return null;
    }


    public void URLnavigation(WebDriver driver) {

        driver.get(Url);
        Reporter.log("Navigate To The Url");

    }

    public void adminLogin(WebDriver driver) throws InterruptedException {

        click("id", "txtUserName", driver, "Click on the user name Field");
        senKeys("id", "txtUserName", "admin", driver, "Enter User Name ");
        click("id", "txtPassword", driver, "Click on The Password Field ");
        Thread.sleep(3000);
        try {
            senKeys("id", "txtPassword", "369963", driver, "Enter Password");
            click("id", "btnLogin", driver, "Click on Login Button");
        } catch (Exception e) {
            Thread.sleep(2000);
            senKeys("id", "txtPassword", "369963", driver, "Enter Password");
            click("id", "btnLogin", driver, "Click on Login Button");
        }

    }

    String ESKACareNetLocator = "rptApplications_ctl04_lblCSS";
    String CareNetSettingsLocator = "rptApplications_ctl04_rptSystem_ctl00_lblfontSys";
    String DataManagmentLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_lnkModule";

    public void dataManagementLinkNavigation(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        click("id", ESKACareNetLocator, driver, "Click on CareNet Link");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings");
        click("id", DataManagmentLocator, driver, "Click on Data Management's Link");
    }

    public void communicationLinkNavigation(WebDriver driver) {
        String CommunicationLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl05_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", CommunicationLinkLocator, driver, "Click on Data Management Locator");
    }

    public void integreationLinknavigation(WebDriver driver) {
        String IntegrationSettingsLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl04_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", IntegrationSettingsLocator, driver, "Click on Data Management Locator");
    }

    public void qualityControlLinkNavigation(WebDriver driver) {
        String QualityControlLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl07_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", QualityControlLocator, driver, "Click on Data Management Locator");
    }

    public void insuranceLinknavigation(WebDriver driver) {
        String InsurancelLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", InsurancelLocator, driver, "Click on Data Management Locator");
    }

    public void NavigateToRoomsManagementLink(WebDriver driver) {
        String RoomsManagementLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", RoomsManagementLocator, driver, "Click on Data Management Locator");
    }


    public void medicalProvidersLinkNavigation(WebDriver driver) {
        String MedicalProvidersLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", MedicalProvidersLocator, driver, "Click on Medical Providers Locator");
    }

    public void agreementsLinknavigation(WebDriver driver) {
        String AgreementsLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl03_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", AgreementsLocator, driver, "Click on Medical Providers Locator");
    }

    public void screenShot(WebDriver driver, ITestResult result, String methodName) {
        final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
        String methodNameString = methodName.toString();
        methodNameString = result.getName();

        try {

            System.setProperty(ESCAPE_PROPERTY, "true");
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String ImageName = methodNameString + "_"
                    + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
                    + ".png";
            File failureImageFileName = new File(System.getProperty("user.dir")
                    + File.separator
                    + "TakesScreenshot" + File.separator + ImageName);
            FileUtils.copyFile(scrFile, failureImageFileName);
            Reporter.setCurrentTestResult(result);
            Reporter.log("########################################");
            Reporter.log("Test Case " + methodName + " Executed with status = Failed  ");
            Reporter.log("The screenshot has been Captured Correctly with name :: " + ImageName);
            Reporter.log("########################################");


            // Reporter.log("<br><img src='" + failureImageFileName + "' height='300' width='300'/><br>");
            // Reporter.log("<a href='" + failureImageFileName + "'>DiscountManagement_screenshot</a>");

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public static String generateString() {
        String uuid = java.util.UUID.randomUUID().toString();
        uuid = uuid.substring(0, Math.min(uuid.length(), 5));
        System.err.println(uuid);
        return uuid;
    }

    public static WebElement Clear(String locatorType, String locator, WebDriver driver, String StepDescription) {
        Wait = new WebDriverWait(driver, 10);

        WebElement elem = null;
        locatorType = locatorType.toLowerCase();
        switch (locatorType) {
            case "id":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator))).clear();
                Reporter.log(StepDescription);
                break;
            case "name":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator))).clear();
                Reporter.log(StepDescription);

                break;
            case "xpath":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).clear();
                Reporter.log(StepDescription);

                break;
            case "class":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator))).clear();
                Reporter.log(StepDescription);

                break;
            case "linktext":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator))).clear();
                Reporter.log(StepDescription);

                break;
            case "partiallinktext":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator))).clear();
                Reporter.log(StepDescription);

                break;
            case "cssselector":
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator))).clear();
                Reporter.log(StepDescription);

            default:
                break;
        }
        return elem;
    }

    public static WebElement autoSuggest(String cssSelectorImgSearch, String dvSuggestions, WebDriver driver) throws InterruptedException {
        try {
            driver.findElement(By.cssSelector(cssSelectorImgSearch)).click();
            Reporter.log("Click on Search Icon");
            WebElement dvSuggestionsWait = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(dvSuggestions)));
            if (dvSuggestionsWait.isDisplayed()) {
                WebElement Table = driver.findElement(By.cssSelector(dvSuggestions));
                List<WebElement> Rows = Table.findElements(By.tagName("tr"));
                for (int i = 1; i < Rows.size(); i++) {
                    Rows.get(i).click();
                    Reporter.log("Select the First Option from the autoSuggest Field");
                    break;
                }
            }

        } catch (Exception e) {
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(cssSelectorImgSearch)).click();
            Reporter.log("Click on Search Icon");
            WebElement dvSuggestionsWait = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(dvSuggestions)));
            if (dvSuggestionsWait.isDisplayed()) {
                WebElement Table = driver.findElement(By.cssSelector(dvSuggestions));
                List<WebElement> Rows = Table.findElements(By.tagName("tr"));
                for (int i = 1; i < Rows.size(); i++) {
                    Rows.get(i).click();
                    Reporter.log("Select the First Option from the autoSuggest Field");

                    break;
                }
            }


        }

        return null;
    }

    public static WebElement DDLByValue(String DDLLocaterByName, String Value, WebDriver driver) throws InterruptedException {

        try {
            Select DDL = new Select(driver.findElement(By.name(DDLLocaterByName)));
            DDL.selectByVisibleText(Value);
            Reporter.log("Select " + Value + " From the DDL");

        } catch (Exception e) {
            Thread.sleep(2000);
            Select DDL = new Select(driver.findElement(By.name(DDLLocaterByName)));
            DDL.selectByVisibleText(Value);
            Reporter.log("Select " + Value + " From the DDL");
        }


        return null;
    }

    public static WebElement DDLByIndex(String DDLBycssSelector, Integer Index, WebDriver driver) throws InterruptedException {

        try {
            Select DDL = new Select(driver.findElement(By.cssSelector(DDLBycssSelector)));
            DDL.selectByIndex(Index);
            Reporter.log("Select " + Index + " From the DDLBycssSelector");

        } catch (Exception e) {
            Thread.sleep(2000);
            Select DDL = new Select(driver.findElement(By.cssSelector(DDLBycssSelector)));
            DDL.selectByIndex(Index);
            Reporter.log("Select " + Index + " From the DDLBycssSelector");
        }


        return null;
    }

    public static WebElement TodayDate(String CalendarImagecssselector, String TodayDatecssselector, WebDriver driver) throws InterruptedException {

        try {
            click("cssselector", CalendarImagecssselector, driver, "Click on Calender Image");
            click("cssselector", TodayDatecssselector, driver, "Select Today Date ");

        } catch (Exception e) {
            Thread.sleep(2000);
            click("cssselector", CalendarImagecssselector, driver, "Click on Calender Image");
            click("cssselector", TodayDatecssselector, driver, "Select Today Date ");

        }


        return null;
    }


    public static WebElement autocomplete(String AutoCompleteTextLocator, String ValueToSearch, WebDriver driver) throws InterruptedException {
        WebElement AutoCompleteTextLocatorWait = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(AutoCompleteTextLocator)));
        if (AutoCompleteTextLocatorWait.isDisplayed()) {
            AutoCompleteTextLocatorWait.click();
            AutoCompleteTextLocatorWait.sendKeys(ValueToSearch);
            Thread.sleep(2000);
            Actions action = new Actions(driver);
            action.sendKeys(AutoCompleteTextLocatorWait, Keys.ARROW_DOWN).perform();
            action.sendKeys(AutoCompleteTextLocatorWait, Keys.RETURN).perform();
        }

        return null;
    }

    public static void assertOperationDoneSuccessfully() throws InterruptedException {
        try {
            String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("info_message"))).getText();
            String ExpectedResult1 = "x\n" +
                    "Operation Done Successfully .";
            Assert.assertEquals(ActualResult1, ExpectedResult1, "Operation Done Successfully .");

        } catch (Exception e) {
            Thread.sleep(2000);
            String ActualResult1 = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("info_message"))).getText();
            String ExpectedResult1 = "x\n" +
                    "Operation Done Successfully .";
            Assert.assertEquals(ActualResult1, ExpectedResult1, "Operation Done Successfully .");

        }

    }

    public static void clickOnTheRowTable(WebDriver driver) throws InterruptedException {
        try {
            click("xpath", "//table/tbody/tr[2]", driver, "click on the Row");

        } catch (Exception e) {
            Thread.sleep(3000);
            click("xpath", "//table/tbody/tr[2]", driver, "click on the Row");

        }


    }

    public static void acceptTheWebPageAlert(WebDriver driver) {

        driver.switchTo().alert().accept();
        Reporter.log("Accept the WebPage Alert");
    }

    public static void assertByPageName(String ExpectedResultPageName) {

        String ActualResult = Wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ctl00_lblPageName"))).getText();
        Assert.assertEquals(ActualResult, ExpectedResultPageName, ExpectedResultPageName + "Page not opened Properly");

    }


    public static void clickOnAddButton(WebDriver driver) {
        click("cssselector", "a[id$='ibtnAdd']", driver, "Click on Add Button");

    }

    public static void clickOnSearchButton(WebDriver driver) throws InterruptedException {

        try {
            click("cssselector", "input[id$='btnSearch']", driver, "Click on Search Button");

        } catch (Exception e) {
            Thread.sleep(2000);
            click("cssselector", "input[id$='btnSearch']", driver, "Click on Search Button");

        }
    }

    public static void clickOnDeleteButton(WebDriver driver) throws InterruptedException {

        try {
            click("cssselector", "a[id$='ibtnDelete']", driver, "Click on Delete Button");
        } catch (Exception e) {
            Thread.sleep(1000);
            click("cssselector", "a[id$='ibtnDelete']", driver, "Click on Delete Button");

        }

    }

    public static void clickOnSaveButton(WebDriver driver) throws InterruptedException {
        try {
            click("cssselector", "input[id*='btnSave']", driver, "Click on Save Button");

        } catch (Exception e) {
            Thread.sleep(1000);
            click("cssselector", "input[id*='btnSave']", driver, "Click on Save Button");


        }

    }

    public static void clickOnUpdateButton(WebDriver driver) {
        click("cssselector", "input[id*='btnUpdate']", driver, "Click on update Button");

    }

    public static void clickOnShowAllButton(WebDriver driver) {
        click("cssselector", "input[id*='btnShowAll']", driver, "Click on Search Button");

    }

    public static void scrollDown(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

    }


    public static WebDriver theBrowser() {
        Reporter.log("Screenshot Capture in TestNG Results Started");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        Reporter.log("ChromeDriver is Opened And Maximized ");
        return driver;
    }

    public String AllergiesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl02_lblfontFrm";
    public String BodySystemPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl04_lblfontFrm";
    public String CheckListPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl19_lblfontFrm";
    public String ClinicalExaminationPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl14_lblfontFrm";
    public String ContainerTypesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl10_lblfontFrm";
    public String DiscountManagementPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl26_lblfontFrm";
    public String DiseasesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl01_lblfontFrm";
    public String ImportMedicinesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl27_lblfontFrm";
    public String InventoryManagementUnitsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl25_lblfontFrm";
    public String KnowledgeBasePageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl24_lblfontFrm";
    public String LabSampleTypesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl09_lblfontFrm";
    public String LabTestsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl12_lblfontFrm";
    public String LabUnitsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl11_lblfontFrm";
    public String LookupItemsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl22_lblfontFrm";
    public String MangeProvidersPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl23_lblfontFrm";
    public String MedicalFormAttribuetsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl17_lblfontFrm";
    public String MedicalFormCodesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl18_lblfontFrm";
    public String MedicalFormsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl16_lnkForms";
    public String MedicalServiceCategoryPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl05_lblfontFrm";
    public String MedicalServicesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl06_lblfontFrm";
    public String MedicinesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl07_lblfontFrm";
    public String RadiologyProcedurePageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl13_lblfontFrm";
    public String SpecialtiesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl20_lblfontFrm";
    public String SpecialtyServicesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl21_lblfontFrm";
    public String SurgeriesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl15_lblfontFrm";
    public String UserSignaturePageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl08_lblfontFrm";
    public String SymptomsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl00_lblfontFrm";
    public String VaccinesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_rptForms_ctl03_lblfontFrm";
    //**********************************************************************************************///
    public String BranchSettingsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl02_lblfontFrm";
    public String MachineServicePageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl09_lblfontFrm";
    public String MachineSetupPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl08_lblfontFrm";
    public String MachineTypePageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl07_lblfontFrm";
    public String NetworkProvidersPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl00_lblfontFrm";
    public String NonNetworkProvidersPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl01_lblfontFrm";
    public String ProviderItemsManagementPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl10_lblfontFrm";
    public String ProviderServicesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl06_lblfontFrm";
    public String ProviderStaffPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl04_lblfontFrm";
    public String ScheduleSettingsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_rptForms_ctl03_lblfontFrm";
    //**********************************************************************************************///
    public String AssetTypesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_rptForms_ctl00_lnkForms";
    public String FloorsManagementPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_rptForms_ctl04_lblfontFrm";
    public String RoomAssetPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_rptForms_ctl01_lblfontFrm";
    public String RoomsCategoriesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_rptForms_ctl02_lblfontFrm";
    public String RoomsManagementPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_rptForms_ctl03_lblfontFrm";
    //**********************************************************************************************///
    public String PayersNetworksPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl03_rptForms_ctl00_lblfontFrm";
    public String PriceListsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl03_rptForms_ctl01_lblfontFrm";
    public String PayersAgreementPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl03_rptForms_ctl02_lblfontFrm";
    public String ApprovalsSetupPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl03_rptForms_ctl03_lblfontFrm";
    public String ExcludedServicesAndDiseasesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl03_rptForms_ctl04_lblfontFrm";
    //**********************************************************************************************///
    public String FinancialProviderSettingsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl04_rptForms_ctl00_lblfontFrm";
    //**********************************************************************************************///
    public String MailboxPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl05_rptForms_ctl00_lblfontFrm";
    public String AnnouncementPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl05_rptForms_ctl05_lblfontFrm";
    public String CommunicationSettingsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl05_rptForms_ctl02_lblfontFrm";
    public String ContactsManagementPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl05_rptForms_ctl04_lblfontFrm";
    public String EventTemplatesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl05_rptForms_ctl01_lblfontFrm";
    public String GroupsManagementPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl05_rptForms_ctl03_lblfontFrm";
    public String MembersQuestionsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl05_rptForms_ctl06_lblfontFrm";
    //**********************************************************************************************///

    public String InsuranceAgreementPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl00_lblfontFrm";
    public String RemittanceAdvicesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl01_lblfontFrm";
    public String ClaimsAuditingPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl02_lblfontFrm";
    public String ClaimsSubmissionPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl03_lblfontFrm";
    public String ClaimsProcessingPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl04_lblfontFrm";
    public String PreAuthServicesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl05_lblfontFrm";
    public String ClaimsStatisticsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl06_lblfontFrm";
    public String AuthorizationsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl07_lblfontFrm";
    public String ExpiredInsuranceCardsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl08_lblfontFrm";
    public String InsuranceClaimAuditingPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl09_lblfontFrm";
    public String ClaimRulesPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl10_lblfontFrm";
    public String ResubmissionLeftDaysPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl11_lblfontFrm";
    public String ClaimsFileManagerPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl12_lblfontFrm";
    public String PayersPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl13_lblfontFrm";
    public String InsuranceCompanyProviderPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl14_lblfontFrm";
    public String StatementOfAccountPerCompanyPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl16_lblfontFrm";
    public String StatementOfAccountReportPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_rptForms_ctl15_lblfontFrm";
    //**********************************************************************************************///

    public String LabQCResultsPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl07_rptForms_ctl00_lblfontFrm";
    public String LotsNumbersPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl07_rptForms_ctl01_lblfontFrm";
    public String DefinalizationConfirmationPageID = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl07_rptForms_ctl02_lblfontFrm";


}








