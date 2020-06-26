package privalia;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
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
        driver.get("https://mex.privalia.com/");

        //encontrar el elemento banner de privalia
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("claim"))).isDisplayed();
    }


    @Then("All the featured ads are up to date")
    public void allTheFeaturedAdsAreUpToDate() {
        List<WebElement> destacados = driver.findElements(By.xpath("//h2[ text() = 'Destacados']/following-sibling::article"));

        for(WebElement destacado: destacados){
            String campanaElementLink = driver.findElement(By.cssSelector(".preopen-info a")).getAttribute("href");
            System.out.println(campanaElementLink);
            String campañaArticulo = destacado.getAttribute("data-prv-campaignname");
            String artEnCampana = campañaArticulo.replaceAll(" ","-");
            System.out.println(artEnCampana);
            campanaElementLink.contains(campañaArticulo);
            System.out.println(campañaArticulo);
            WebElement vigencia = destacado.findElement(By.cssSelector(".item-dataInfo"));
        }

    }

    @Then("All the current ads are up to date")
    public void allTheCurrentAdsAreUpToDate() {
        List<WebElement> estrenados = driver.findElements(By.xpath("//h2[ text() = 'Hoy Estrenados']/following-sibling::article"));

        for (WebElement estrenado : estrenados) {
            WebElement vigencia = estrenado.findElement(By.cssSelector(".item-dataInfo"));
            System.out.println(vigencia.getText());
        }
    }

    @Then("Coming up promotions don´t have a due date")
    public void comingUpPromotionsDonTHaveADueDate() {
            List<WebElement> futuros = driver.findElements(By.xpath("//h2[ text() = 'Próximamente']/following-sibling::article"));

            for(WebElement futuro: futuros) {
                WebElement vigencia = futuro.findElement(By.cssSelector(".item-dataInfo"));
                System.out.println(vigencia.getText());
            }
    }
}
