package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class ScrapeStepDefinitions {
    private WebDriver driver;

    static final Logger log = getLogger(lookup().lookupClass());

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().arm64().win().forceDownload().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Given("Navigate to {string}")
    public void navigateTo(String string) {
        driver.get(string);
        driver.navigate().to(string);

        log.debug("The url was hit");
    }

//    List<WebElement> list = driver.findElements(By.xpath(""));
}
