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
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class BasePage {
    private static final java.util.UUID UUID = null;
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


    public void navigateToUrl(WebDriver driver) {

        driver.get(Url);
        Reporter.log("Navigate To The Url");

    }

    public void LoginWithAdminUser(WebDriver driver) throws InterruptedException {

        click("id", "txtUserName", driver, "Click on the user name Field");
        senKeys("id", "txtUserName", "admin", driver, "Enter User Name ");
        click("id", "txtPassword", driver, "Click on The Password Field ");
        Thread.sleep(2000);
        senKeys("id", "txtPassword", "369963", driver, "Enter Password");
        click("id", "btnLogin", driver, "Click on Login Button");
    }

    public void NavigateToDataManagmentLink(WebDriver driver) {
        String ESKACareNetLocator = "rptApplications_ctl04_lblCSS";
        String CareNetSettingsLocator = "rptApplications_ctl04_rptSystem_ctl00_lblfontSys";
        String DataManagmentLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl00_lnkModule";
        click("id", ESKACareNetLocator, driver, "Click on CareNet Link");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings");
        click("id", DataManagmentLocator, driver, "Click on Data Management's Link");
    }

    public void NavigateToCommunicationLink(WebDriver driver) {
        String ESKACareNetLocator = "rptApplications_ctl04_lblCSS";
        String CareNetSettingsLocator = "rptApplications_ctl04_rptSystem_ctl00_lblfontSys";
        String CommunicationLinkLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl05_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", CommunicationLinkLocator, driver, "Click on Data Management Locator");
    }

    public void NavigateToIntegrationSettingsLink(WebDriver driver) {
        String ESKACareNetLocator = "rptApplications_ctl04_lblCSS";
        String CareNetSettingsLocator = "rptApplications_ctl04_rptSystem_ctl00_lblfontSys";
        String IntegrationSettingsLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl04_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", IntegrationSettingsLocator, driver, "Click on Data Management Locator");
    }

    public void NavigateToQualityControlLink(WebDriver driver) {
        String ESKACareNetLocator = "rptApplications_ctl04_lblCSS";
        String CareNetSettingsLocator = "rptApplications_ctl04_rptSystem_ctl00_lblfontSys";
        String QualityControlLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl07_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", QualityControlLocator, driver, "Click on Data Management Locator");
    }

    public void NavigateToInsuranceLink(WebDriver driver) {
        String ESKACareNetLocator = "rptApplications_ctl04_lblCSS";
        String CareNetSettingsLocator = "rptApplications_ctl04_rptSystem_ctl00_lblfontSys";
        String InsurancelLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl06_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", InsurancelLocator, driver, "Click on Data Management Locator");
    }

    public void NavigateToRoomsManagementLink(WebDriver driver) {
        String ESKACareNetLocator = "rptApplications_ctl04_lblCSS";
        String CareNetSettingsLocator = "rptApplications_ctl04_rptSystem_ctl00_lblfontSys";
        String RoomsManagementLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl02_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", RoomsManagementLocator, driver, "Click on Data Management Locator");
    }

    public void NavigateToMedicalProvidersLink(WebDriver driver) {
        String ESKACareNetLocator = "rptApplications_ctl04_lblCSS";
        String CareNetSettingsLocator = "rptApplications_ctl04_rptSystem_ctl00_lblfontSys";
        String MedicalProvidersLocator = "rptApplications_ctl04_rptSystem_ctl00_rptModule_ctl01_lblfontMod";
        click("id", ESKACareNetLocator, driver, "Click on ESKA CareNet Locator");
        click("id", CareNetSettingsLocator, driver, "Click on CareNet Settings Locator");
        click("id", MedicalProvidersLocator, driver, "Click on Medical Providers Locator");
    }

    public void NavigateToAgreements(WebDriver driver) {
        String ESKACareNetLocator = "rptApplications_ctl04_lblCSS";
        String CareNetSettingsLocator = "rptApplications_ctl04_rptSystem_ctl00_lblfontSys";
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

    public static WebElement autoSuggest(String imgSearch, String dvSuggestions, WebDriver driver) throws InterruptedException {
        try {
            driver.findElement(By.cssSelector(imgSearch)).click();
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
            driver.findElement(By.cssSelector(imgSearch)).click();
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

    public static WebElement DDL(String DDLLocaterByName, String Value, WebDriver driver) throws InterruptedException {

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

    public static WebElement TodayDate(String CalendarImageLocator, String TodayDateLocator, WebDriver driver) throws InterruptedException {

        try {
            click("cssselector", CalendarImageLocator, driver, "Click on Calender Image");
            click("cssselector", TodayDateLocator, driver, "Select Today Date ");

        } catch (Exception e) {
            Thread.sleep(2000);
            click("cssselector", CalendarImageLocator, driver, "Click on Calender Image");
            click("cssselector", TodayDateLocator, driver, "Select Today Date ");

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


}








