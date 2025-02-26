package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertionUtils;
import utils.ConfigManager;


public class LoginPage extends BasePage {

    @FindBy(className = "login_page-header")
    private WebElement logo_LoginPage;
    @FindBy(name = "username")
    private WebElement usernameTextBox;
    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordTextBox;
    @FindBy(css = "div[class*=\"login_page-form_submit\"] button")
    private WebElement loginBtn;
    @FindBy(css = "div.login_page-response_message")
    private WebElement response_message;
    @FindBy(xpath = "//div[@class='login_page-response_message']")
    private WebElement response_message2;
    @FindBy(css = "div[class*='Next4bizUI-form-item_action login_page-form_timer']")
    private WebElement twoFactor_countdown;
    @FindBy(xpath = "//div[contains(@class, 'Next4bizUI-form-item_outer') and .//label[contains(text(), 'Username')]]//div[@class='Next4bizUI-form-item_error-inner']/span[text()='This field is required!']")
    private WebElement emptyUserNameError;
    @FindBy(xpath = "//div[contains(@class, 'mantine-PasswordInput-root')]/parent::div//span")
    private WebElement emptyPasswordError;
    private final String baseUrl;

    public LoginPage() {
        super();
        this.baseUrl = ConfigManager.getProperty("base_url"); // Ortama göre URL'yi al
    }

    public void login(String username, String password) {
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        waitUtils.waitForElementToBeClickable(loginBtn);
        loginBtn.click();
    }

    public void open() {
        driver.get(baseUrl + "/login");  // Ortam bazlı URL kullanımı
    }

    public void logout() {
        driver.get(baseUrl + "/logout"); // Ortam bazlı URL kullanımı
    }

    public String getResponseMessage() {
        return waitUtils.waitForPresenceOfElementLocated(By.className("login_page-response_message")).getText();
    }


    public String getTextEmptyUserNameError() {
        return waitUtils.waitForVisibility(emptyUserNameError).getText();
    }

    public boolean isDisplayedEmptyUserNameError() {
        try {
            return waitUtils.waitForVisibility(emptyUserNameError).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTextEmptyPasswordError() {
        return waitUtils.waitForVisibility(emptyPasswordError).getText();
    }

    public boolean isDisplayedEmptyPasswordError() {
        try {
            return waitUtils.waitForVisibility(emptyPasswordError).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayedWebElement(WebElement element) {
        try {
            return waitUtils.waitForVisibility(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isPresentWebElement(By locator) {
        try {
            waitUtils.waitForPresenceOfElementLocated(locator);
            return true;  // Element is found
        } catch (TimeoutException e) {
            return false; // Element not found within timeout
        }
    }

    public void verifyErrorMessage(String expected, String actual, String message) {
        AssertionUtils.assertTextEquals(expected, actual, message);
    }

    public void verifyNotLoggedIn() {
        AssertionUtils.assertTrue(!isDisplayedWebElement(response_message), "User is not logged in");
        //AssertionUtils.assertTrue(!isDisplayedSuccessfulResponseMessage(), "User is not logged in");
    }

    public void verifyUserIsOnLoginPage() {
        AssertionUtils.assertTrue(driver.getCurrentUrl().contains("login"), "User is not on the login page");
    }

    public void verifyLoggedIn() {
        AssertionUtils.assertTrue(isDisplayedWebElement(response_message), "User is logged in");
        //AssertionUtils.assertTrue(isDisplayedSuccessfulResponseMessage(), "User is logged in");
    }

    public void verifyRedirectedToHomePage() {
        // Wait for redirection to the main page
        waitUtils.waitForUrlContains("https://tesla.example.co/crm/latest-activity");
        // Ensure a key element of the main page is loaded
        waitUtils.waitForPresenceOfElementLocated(By.xpath("//div[@class='app_mobile-header_nav-logo']"));
        AssertionUtils.assertAll(
                () -> AssertionUtils.assertTextEquals("https://tesla.example.co/crm/latest-activity", driver.getCurrentUrl(), "User is not redirected to the home page")
        );
        AssertionUtils.assertTrue(driver.getCurrentUrl().contains("latest-activity"), "User is redirected to the home page");
        AssertionUtils.assertTrue(isPresentWebElement(By.xpath("//div[@class='app_mobile-header_nav-logo']")), "User is redirected to the home page");

    }


}

