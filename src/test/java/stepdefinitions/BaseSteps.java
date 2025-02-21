package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public class BaseSteps {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    // Statik blok ile sadece ilk çağrıldığında bir kere çalıştır
    static {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}
