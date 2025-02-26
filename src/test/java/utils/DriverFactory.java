package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    public static void createDriver(String browser) {
        WebDriver webDriver;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = BrowserOptions.getChromeOptions();
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Geçersiz tarayıcı adı: " + browser);
        }

        webDriver.manage().window().maximize(); // Tüm tarayıcılar için tam ekran
        setDriver(webDriver);
    }
}
