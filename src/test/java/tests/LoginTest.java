package tests;


import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.AssertionUtils;
import utils.WaitUtils;

import java.time.Duration;

import static utils.Constants.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    WaitUtils waitUtils;

    @BeforeEach
    public void before() {
        super.before();
        waitUtils = new WaitUtils(driver, Duration.ofSeconds(10));
        loginPage.open();
    }

    @Description("Boş kullanıcı adı/doğru şifre ile uyarı mesajı")
    @Test
    @Order(1)
    @DisplayName("Boş kullanıcı adı/doğru şifre ile uyarı mesajı")
    public void testEmptyInfoLogin() {
        loginPage.login("", TESLA_PASSWORD);
        Assertions.assertAll(
                () -> Assertions.assertTrue(loginPage.isDisplayedEmptyUserNameError()),
                () -> Assertions.assertEquals(ERROR_USERNAME_REQUIRED_EN, loginPage.getTextEmptyUserNameError())
        );
        // Print success message to console
        System.out.println("Test case 'testEmptyInfoLogin' passed successfully.");
    }

    @Description("Doğru kullanıcı adı/boş şifre ile uyarı mesajı")
    @Test
    @Order(2)
    @DisplayName("Doğru kullanıcı adı/boş şifre ile uyarı mesajı")
    public void testEmptyPasswordLogin() {
        loginPage.login(TESLA_USERNAME, "");
        Assertions.assertAll(
                () -> Assertions.assertTrue(loginPage.isDisplayedEmptyPasswordError()),
                () -> Assertions.assertEquals(ERROR_PASSWORD_REQUIRED_EN, loginPage.getTextEmptyPasswordError())
        );
        // Print success message to console
        System.out.println("Test case 'testEmptyPasswordLogin' passed successfully.");
    }

    //@Disabled("Skip etme sebebi: Test başarılı bir şekilde çalıştığı için tekrar çalıştırmaya gerek yok.")
    @Description("Başarılı login Senaryosu")
    @Test
    @Order(3)
    @DisplayName("Başarılı Login Senaryosu")
    public void testSuccessfulLogin() {
        loginPage.login(TESLA_USERNAME, TESLA_PASSWORD);

        // Wait for redirection to the main page
        waitUtils.waitForUrlContains("https://tesla.example.co/crm/latest-activity");

        // Ensure a key element of the main page is loaded
        waitUtils.waitForPresenceOfElementLocated(By.xpath("//div[@class='app_mobile-header_nav-logo']"));

        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.open();

        AssertionUtils.assertAll(
                () -> AssertionUtils.assertTextEquals(TESLA_USERNAME, myAccountPage.getUserName(), "Kullanıcı adı yanlış!"),
                () -> AssertionUtils.assertTextEquals("https://tesla.example.co/myaccount", driver.getCurrentUrl(), "Yanlış sayfaya yönlendirildi!")
        );

        Assertions.assertEquals(TESLA_USERNAME, myAccountPage.getUserName(), "Kullanıcı adı yanlış!");
        Assertions.assertEquals("https://tesla.example.co/myaccount", driver.getCurrentUrl(), "Yanlış sayfaya yönlendirildi!");

        // Print success message to console
        System.out.println("Test case 'testSuccessfulLogin' passed successfully.");

    }

}
