package FirstTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FirstTaskPage {
    public static WebDriver driver;

    public FirstTaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "account")
    WebElement account;

    @FindBy(css = "a[href*=addresses] i")
    WebElement addresses;

    @FindBy(css = "a[data-link-action=add-address]")
    WebElement newAddress;

    @FindBy(name = "alias")
    WebElement aliasInput;

    @FindBy(name = "address1")
    WebElement addressInput;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "postcode")
    WebElement postcodeInput;

    @FindBy(name = "id_country")
    WebElement countryInput;

    @FindBy(name = "phone")
    WebElement phoneInput;

    @FindBy(css = ".btn.btn-primary")
    WebElement saveButton;

    @FindBy(xpath = "//article[@class-'address']")
    WebElement last;

    @FindBy(xpath = "//*[@id='content']/descendant::h4[position()=2]/following::span[position()=2]")
    WebElement deleteButton;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[1]/h4")
    List<WebElement> alias;

    @FindBy(xpath = "//address")
    List<WebElement> equalsAddress;

    public void loginAs(String email, String password) {
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

    public void goToAccountDetail() {
        account.click();
        addresses.click();
        newAddress.click();
    }

    public void setAddress(String alias, String address, String city, String postcode, String county, String phone){
        aliasInput.click();
        aliasInput.sendKeys(alias);
        addressInput.click();
        addressInput.sendKeys(address);
        cityInput.click();
        cityInput.sendKeys(city);
        postcodeInput.click();
        postcodeInput.sendKeys(postcode);
        countryInput.click();
        countryInput.sendKeys(county);
        phoneInput.click();
        phoneInput.sendKeys(phone);
    }

    public void saveInformation() throws InterruptedException {
        Thread.sleep(1000);
        saveButton.click();
    }

    public String getAlias() {
        return alias.get(alias.size()-1).getText();
    }
    public String getAddressText () {
        return equalsAddress.get(equalsAddress.size()-1).getText();
    }

    public void deleteAddress() {
        deleteButton.click();
    }
}