package privalia;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StepDefs {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUpTest() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver(opt);
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().setSize(new Dimension(900, 550));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDownTest() {
        driver.quit();
    }

    @Given("I am in Privalia Home Page")
    public void iAmInPrivaliaHomePage() {

    }


    @Then("All the featured ads are up to date")
    public void allTheFeaturedAdsAreUpToDate() {

    }

    @Then("All the current ads are up to date")
    public void allTheCurrentAdsAreUpToDate() {

    }

    @Then("Coming up promotions don´t have a due date")
    public void comingUpPromotionsDonTHaveADueDate() {
    }
}
