package SecondTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondTaskPage {
    public static WebDriver driver;

    public SecondTaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "s")
    WebElement search;

    @FindBy(xpath = "//span[@class='product']")
    WebElement chooseProduct;

    @FindBy(name = "group[1]")
    WebElement chooseSize;

    @FindBy(name = "qty")
    WebElement chooseQuantity;

    @FindBy(xpath = "//div[@class='add']/button")
    WebElement addToCart;

    @FindBy(xpath = "//div[@class='cart-content-btn']/a")
    WebElement goToCheckout;

    @FindBy(css = ".btn.btn-primary")
    WebElement proceedToCheckout;

    @FindBy (name = "confirm-addresses")
    WebElement chooseAddress;

    @FindBy (name = "confirmDeliveryOption")
    WebElement chooseDelivery;

    @FindBy (id = "payment-option-1")
    WebElement choosePayment;

    @FindBy (name = "conditions_to_approve[terms-and-conditions]")
    WebElement agreeTerms;

    @FindBy (css = ".btn.btn-primary.center-block")
    WebElement orderButton;

    @FindBy (className = "account")
    WebElement account;

    @FindBy (css = "a[href*=history]")
    WebElement history;


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

    public void searchItem () {
        search.click();
        search.sendKeys("HUMMINGBIRD PRINTED SWEATER");
        chooseProduct.click();
    }

    public void chooseSizeAndQuantity (String size, String quantity) throws InterruptedException {
        chooseSize.click();
        chooseSize.sendKeys(size);
        chooseSize.click();
        chooseQuantity.click();
        Thread.sleep(1500);
        chooseQuantity.clear();
        chooseQuantity.sendKeys(quantity);
        addToCart.click();
    }

    public void checkout () throws InterruptedException {
        Thread.sleep(1500);
        goToCheckout.click();
        proceedToCheckout.click();
    }

    public void deliveryAddress () {
        chooseAddress.click();
        chooseDelivery.click();
    }

    public void payment () {
        choosePayment.click();
        agreeTerms.click();
        orderButton.click();
    }

    public void checkHistory () {
        account.click();
        history.click();
    }
}
