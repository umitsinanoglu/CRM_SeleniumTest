package pages;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


import java.util.List;


public class CompanyPage extends BasePage {

    @FindBy(id = "company_name")
    public WebElement inputCompanyName;

    @FindBy(xpath = "//input[@placeholder='Web Sitesi']")
    public WebElement inputWebSite;

    @FindAll(@FindBy(xpath = "//input[contains(@class,'websites-group')]"))
    public List<WebElement> inputWebsites;

    @FindBy(xpath = "//*[@id=\"websitesControls\"]//a[@class='list-add']")
    public WebElement buttonAddWebsites;

    @FindAll(@FindBy(xpath = "//input[contains(@class,'domains-group')]"))
    public List<WebElement> inputDomains;

    @FindBy(xpath = "//*[@id=\"domainsControls\"]//a[@class='list-add']")
    public WebElement buttonAddDomains;

    @FindAll(@FindBy(xpath = "//*[contains(@class,'email_formats-group')]"))
    public List<WebElement> selectEmailFormats;

    @FindBy(xpath = "//*[@id=\"email_formatsControls\"]//a[@class='list-add']")
    public WebElement buttonAddEmailFormat;

    @FindBy(xpath = "//*[@id=\"resource\"]")
    public WebElement inputResource;

    @FindAll(@FindBy(xpath = "//div[contains(@class,'verticalDropdown')]//a"))
    public List<WebElement> selectVerticals;

    @FindAll(@FindBy(xpath = "//*[contains(@class,'phone_kind')]"))
    public List<WebElement> selectPhoneTypes;

    @FindAll(@FindBy(xpath = "//*[contains(@class,'phones-group')]"))
    public List<WebElement> inputPhoneNumbers;

    @FindBy(xpath = "//*[@id=\"phonesControls\"]//a[@class='list-add']")
    public WebElement buttonAddPhoneNumbers;

    @FindBy(id = "phones-default")
    public WebElement buttonDefaultPhone;

    @FindAll(@FindBy(xpath = "//*[contains(@class,'address_kind')]"))
    public List<WebElement> selectAddressTypes;

    @FindAll(@FindBy(xpath = "//*[contains(@class,'address-group')]"))
    public List<WebElement> inputAddressText;

    @FindBy(xpath = "//*[@id=\"addressControls\"]//a[@class='list-add']")
    public WebElement buttonAddAddress;

    @FindAll(@FindBy(xpath = "//*[@id=\"addressControls\"]//*[contains(@class,'country')]"))
    public List<WebElement> selectCountry;

    @FindAll(@FindBy(xpath = "//*[@id=\"addressControls\"]//*[contains(@class,'city')]"))
    public List<WebElement> selectCity;

    @FindAll(@FindBy(xpath = "//*[@id=\"addressControls\"]//*[contains(@class,'district')]"))
    public List<WebElement> selectDistrict;

    @FindBy(id = "default_address_index")
    public WebElement buttonDefaultAddress;

    @FindBy(id = "btnCompanySave")
    public WebElement buttonSave;

    @FindBy(tagName = "html")
    public WebElement __document;

    public CompanyPage() {
        super();
    }

    public void open() {
        driver.get(baseUrl + "/crm/create/company");  // Ortam bazlı URL kullanımı
    }


    public void enterCompanyDetails() {
        Faker faker = new Faker();
        sendKeysToElement(inputCompanyName, faker.company().name());
        //clickElement(buttonAddWebsites);
        sendKeysToElement(inputWebSite, faker.internet().url());

    }
}
