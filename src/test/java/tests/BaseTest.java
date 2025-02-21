package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void before() {
        DriverFactory.createDriver("chrome");
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        System.out.println("Driver oluşturuldu mu? " + (driver != null)); // Debugging
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
