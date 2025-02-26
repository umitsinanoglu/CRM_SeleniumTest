package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigManager;

import java.util.List;

public class PersonPage extends BasePage {

    @FindBy(xpath = "//div[@class='note__addNew']//button[contains(@class,'crud-btn-addon')]")
    public WebElement note_addNew;

    @FindBy(xpath = "//div[@class='note__addNew']//button[contains(@class,'crud-btn-addon')]")
    public WebElement datetimeForTheNote;

    @FindBy(xpath = "//div[@class='detail__card-tabs']//a[@href='#notes']")
    public WebElement notes_tab_link;

    @FindBy(id = "notes")
    public WebElement notes_tab;

    @FindBy(xpath = "//div[contains(@class,'drawer_wrapper-active')]")
    public WebElement notes_drawer;

    @FindBy(xpath = "//div[@class='note__actions']//input[@role='combobox']")
    public WebElement sales_channel_In_Note_Tab;

    @FindBy(xpath = "(//div[@class='deal__drawer_note']//input[@role='combobox'])[1]")
    public WebElement sales_channel_In_Note_Drawer;

    @FindBy(xpath = "//*[contains(@class,'phone_kind')]")
    public WebElement selectPhoneType;

    @FindBy(xpath = "//*[contains(@class,'phones-group')]")
    public List<WebElement> inputPhoneNumbers;

    @FindBy(xpath = "//*[@id='phonesControls']//a[@class='list-add']")
    public WebElement buttonAddPhoneNumbers;

    @FindBy(id = "phones-default")
    public WebElement buttonDefaultPhone;

    @FindBy(xpath = "//*[contains(@class,'address_kind')]")
    public WebElement selectAddressType;

    @FindBy(xpath = "//*[contains(@class,'address-group')]")
    public List<WebElement> inputAddressText;

    @FindBy(xpath = "//*[@id='addressControls']//a[@class='list-add']")
    public WebElement buttonAddAddress;

    @FindBy(xpath = "//*[@id='addressControls']//*[contains(@class,'country')]")
    public WebElement selectCountry;

    @FindBy(xpath = "//*[@id='addressControls']//*[contains(@class,'city')]")
    public WebElement selectCity;

    @FindBy(xpath = "//*[@id='addressControls']//*[contains(@class,'city')]/option")
    public List<WebElement> selectCities;

    @FindBy(xpath = "//*[@id='addressControls']//*[contains(@class,'district')]")
    public WebElement selectDistrict;

    @FindBy(id = "default_address_index")
    public WebElement buttonDefaultAddress;

    @FindBy(className = "yearselect")
    public WebElement old_selectYear;

    @FindBy(className = "monthselect")
    public WebElement old_selectMonth;

    @FindBy(xpath = "//tr/td[@class='available']")
    public List<WebElement> old_selectDays;

    @FindBy(xpath = "//div[@id='emailsControls']//a[@class='list-add']")
    public WebElement btn_addNewEmailAddress;

    @FindBy(xpath = "//label[@class='control-label' and contains(text(),'Person_Text')]//parent::div//input")
    public WebElement CF_Person_Text;

    @FindBy(xpath = "//label[@class='control-label' and contains(text(), 'Person_Number')]//parent::div//input")
    public WebElement CF_Person_Number;

    @FindBy(xpath = "//label[@class='control-label' and contains(text(), 'Person_F_Number')]//parent::div//input")
    public WebElement CF_Person_F_Number;

    @FindBy(xpath = "//label[@class='control-label' and contains(text(), 'Person_Date')]//parent::div//input")
    public WebElement CF_Person_Date;

    @FindBy(xpath = "//label[@class='control-label' and contains(text(), 'Person_DateTime')]//parent::div//input")
    public WebElement CF_Person_DateTime;

    @FindBy(xpath = "//label[@class='control-label' and contains(text(), 'Person_List')]//parent::div//div//div")
    public WebElement CF_Person_List;

    @FindBy(xpath = "//label[@class='control-label' and contains(text(), 'Person_MultiList')]//parent::div//input[not(contains(@class,'off'))]")
    public WebElement CF_Person_MultiList;

    @FindBy(xpath = "//label[@class='control-label' and contains(text(), 'Person_Link')]//parent::div//input")
    public WebElement CF_Person_Link;

    @FindBy(xpath = "//label[@class='control-label' and contains(text(), 'Person_Stamp')]//parent::div//input")
    public WebElement CF_Person_Stamp;

    @FindBy(xpath = "//label[@class='control-label' and contains(text(), 'Person_R_Text')]//parent::div//input")
    public WebElement CF_Person_R_Text;

    @FindBy(id = "name")
    private WebElement inputPersonFirstName;
    @FindBy(id = "surname")
    private WebElement inputPersonLastName;
    @FindBy(id = "gender_id")
    private WebElement selectGender;
    @FindBy(id = "birthdate")
    private WebElement birthdate;
    @FindBy(id = "company")
    private WebElement inputCompany;
    @FindBy(xpath = "//input[@type='radio' and @name='default_email_index']")
    private List<WebElement> defaultEmailRadioButtons;
    @FindBy(name = "emails[0][email_address]")
    private WebElement inputFirstEmailAddress;
    @FindBy(xpath = "//input[contains(@class,'emails-group')]")
    private List<WebElement> inputEmailAddresses;
    @FindBy(id = "title_text")
    private WebElement inputTitle;
    @FindBy(id = "title_id")
    private WebElement inputTitleCategory;
    @FindBy(id = "linkedin_url")
    private WebElement inputLinkedInUrl;
    @FindBy(id = "citizenship_number")
    private WebElement nationalID;
    @FindBy(id = "btnPersonSave")
    private WebElement btn_personSave;
    private final String baseUrl;

    public PersonPage() {
        super();
        this.baseUrl = ConfigManager.getProperty("base_url"); // Ortama göre URL'yi al
    }

    public void open() {
        driver.get(baseUrl + "/crm/create/person");
    }

    public void enterPersonDetails() {
        Faker faker = new Faker();
        sendKeysToElement(inputPersonFirstName, faker.name().firstName());
        sendKeysToElement(inputPersonLastName, faker.name().lastName());
        sendKeysToElement(inputFirstEmailAddress, faker.internet().emailAddress());
        clickElement(defaultEmailRadioButtons.get(0));
    }

    public void save() {
        clickElement(btn_personSave);
    }

    public void verifyPersonCreated() {
        // Verify the person is created
        waitForUrlToBe("/crm/person");
    }
}
