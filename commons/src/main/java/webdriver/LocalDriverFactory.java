package webdriver;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static config.ConfigurationTestAutomationInit.CONFIGURATION_PROPERTIES;

@Log
public class LocalDriverFactory {

    public static WebDriver createInstance(String browser) {
        WebDriver driver = null;
        final String os = System.getenv().get("OS");
        log.info("System version: " + os);
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver",CONFIGURATION_PROPERTIES.getChromeDriverPath());
            driver = new ChromeDriver();
        }
        else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", CONFIGURATION_PROPERTIES.getGeckoDriverPath());
            driver = new FirefoxDriver();
        }
        else {
            log.throwing(LocalDriverFactory.class.getName(), "createInstance", new IllegalArgumentException());
        }
        return driver;
    }
}
