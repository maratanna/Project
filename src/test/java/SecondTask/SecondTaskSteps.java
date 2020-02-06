package SecondTask;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SecondTaskSteps {

    SecondTaskPage secondTaskPage;
    WebDriver driver;

    @Given("^User is logged into examplary shop$")
    public void userIsLoggedIntoExamplaryShop() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        secondTaskPage = new SecondTaskPage(driver);
        secondTaskPage.loginAs("marat.anna@gmail.com", "abc123");
    }

    @When("^User choose item$")
    public void userChooseItem() {
        secondTaskPage.searchItem();
    }

    @And("^User choose \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userChooseAnd(String size, String quantity) throws InterruptedException {
        secondTaskPage.chooseSizeAndQuantity(size, quantity);
    }



    @And("^User choose checkout option$")
    public void userChooseCheckoutOption() throws InterruptedException {
        secondTaskPage.checkout();
    }

    @And("^User confirm delivery address$")
    public void userConfirmDeliveryAddress() {
        secondTaskPage.deliveryAddress();
    }

    @And("^User choose payment method and obligation to pay$")
    public void userChoosePaymentMethodAndObligationToPay() {
        secondTaskPage.payment();
    }

    @Then("^System will do screenshoot with order confirmation$")
    public void systemWillDoScreenshootWithOrderConfirmation() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/home/anna/Desktop/shot.png"));
    }

    @Then("^Check orders history$")
    public void checkOrdersHistory() {
        secondTaskPage.checkHistory();

    }


}
