package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Objects;

public class BrowserOptions {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        if (Objects.equals(ConfigManager.getProperty("headless"), "true")) {
            chromeOptions.addArguments("--headless");
        }
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("devtools.console.stdout.content", true);
        return new FirefoxOptions();
    }

    public static EdgeOptions getEdgeOptions() {
        return new EdgeOptions();
    }

    public static SafariOptions getSafariOptions() {
        return new SafariOptions();
    }

}
