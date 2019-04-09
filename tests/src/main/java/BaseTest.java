import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import webdriver.LocalDriverFactory;
import webdriver.LocalDriverManager;

import static webdriver.LocalDriverManager.getDriver;

@Log
public class BaseTest {

    @Parameters({"browser"})
    @BeforeTest
    public void createAndStartService(@Optional String browser) {
        WebDriver driver = LocalDriverFactory.createInstance(browser);
        LocalDriverManager.setWebDriver(driver);
    }

    @AfterTest
    public void createAndStopService() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}