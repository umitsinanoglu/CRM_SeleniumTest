package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.logging.Level;

public class BrowserOptions {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
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

}
