package webdriver;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static config.ConfigurationTestAutomationInit.CONFIGURATION_PROPERTIES;

@Log
public class LocalDriverFactory {

    public static WebDriver createInstance(String browser) {
        WebDriver driver = null;
        final String os = System.getenv().get("OS");
        log.info("System version: " + os);
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "Windows_NT".equals(os) ? "chromedriver.exe" : "chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(CONFIGURATION_PROPERTIES.getChromeDriverArguments());
            driver = new ChromeDriver(chromeOptions);
        }
        else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "Windows_NT".equals(os) ? "geckodriver.exe" : "geckodriver");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments(CONFIGURATION_PROPERTIES.getChromeDriverArguments());
            driver = new FirefoxDriver();
        }
        else {
            log.throwing(LocalDriverFactory.class.getName(), "createInstance", new IllegalArgumentException());
        }
        return driver;
    }
}
