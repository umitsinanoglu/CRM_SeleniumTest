package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{


    public MyAccountPage() {
        super();
    }

    @FindBy(css = "input[name=\"username\"]")
    private WebElement userName;

    public String getUserName() {
        WebElement userElement = waitUtils.waitForVisibility(userName);
        return userElement.getAttribute("value");
    }


    public void open() {
        driver.get("https://tesla.example.co/myaccount"); // Direkt URL'ye git
    }
}
