package webdriver;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;

@Log
public class LocalDriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}
