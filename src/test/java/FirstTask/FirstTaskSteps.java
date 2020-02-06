package FirstTask;

import SecondTask.SecondTaskPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class FirstTaskSteps {

    FirstTaskPage firstTaskPage;
    WebDriver driver;

    @Given("^User is logged in to the shop$")
    public void userIsLoggedInToTheShop() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        firstTaskPage = new FirstTaskPage(driver);
        firstTaskPage.loginAs("marat.anna@gmail.com", "abc123");

        firstTaskPage = new FirstTaskPage(driver);
    }

    @When("^Logged user goes to address$")
    public void loggedUserGoesToAddress() {
        firstTaskPage.goToAccountDetail();
    }

    @And("^User add \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userAddAnd(String alias, String address, String city, String postcode, String country, String phone) {
        firstTaskPage.setAddress(alias, address, city, postcode, country, phone);
    }

    @And("^User saves all information$")
    public void userSavesAllInformation() {
        firstTaskPage.saveInformation();
    }

    @And("^New address is added and equals \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void newAddressIsAddedAndEqualsAnd(String alias, String address, String city, String postcode, String country, String phone)  {
        String lastAlias = firstTaskPage.getAlias();
        String lastAddress = firstTaskPage.getAddressText();
        System.out.println(lastAlias);
        System.out.println(lastAddress);
        Assert.assertTrue(lastAlias.contains(alias));
        Assert.assertTrue(lastAddress.contains(address));
        Assert.assertTrue(lastAddress.contains(city));
        Assert.assertTrue(lastAddress.contains(postcode));
        Assert.assertTrue(lastAddress.contains(country));
        Assert.assertTrue(lastAddress.contains(phone));
    }

    @Then("^Logged user deleted address and can see \"([^\"]*)\"$")
    public void loggedUserDeletedAddressAndCanSee(String arg0) {
        firstTaskPage.deleteAddress();
    }
}