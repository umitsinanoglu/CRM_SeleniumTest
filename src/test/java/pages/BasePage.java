package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigManager;
import utils.DriverFactory;
import utils.WaitUtils;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;
    protected String baseUrl;

    public BasePage() {
        driver = DriverFactory.getDriver();
        waitUtils = new WaitUtils(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        this.baseUrl = ConfigManager.getProperty("base_url");
    }

    public void sendKeysToElement(WebElement element, String text) {
        // Send keys to element
        waitUtils.waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        // Click element
        waitUtils.waitForElementToBeClickable(element);
        element.click();
    }

    public void waitForUrlToBe(String fragmentUrl) {
        // Wait for URL to be
        waitUtils.waitForUrlToBe(fragmentUrl);
    }
}
