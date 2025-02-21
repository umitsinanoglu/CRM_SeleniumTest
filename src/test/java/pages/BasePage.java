package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
import utils.WaitUtils;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage() {
        driver = DriverFactory.getDriver();
        waitUtils = new WaitUtils(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

}
