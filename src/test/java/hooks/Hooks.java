package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {

    private WebDriver driver;

    @Before("@StartCRM")
    public void setUp() {
        DriverFactory.createDriver("chrome");
        driver = DriverFactory.getDriver(); // ThreadLocal içindeki WebDriver nesnesini al
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver(); // ThreadLocal içindeki WebDriver nesnesini kapat
    }


}
