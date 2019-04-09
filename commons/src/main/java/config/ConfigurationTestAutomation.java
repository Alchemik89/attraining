package config;

import lombok.Getter;
import lombok.extern.java.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Log
public class ConfigurationTestAutomation {

    @Getter
    private String chromeDriverPath;
    @Getter
    private String geckoDriverPath;

    public static Properties readPropertiesFile() throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("../config.properties"));
        } catch (FileNotFoundException e)
        {
            properties.load(new FileInputStream("config.properties"));
        }
        return properties;
    }

    public ConfigurationTestAutomation() {
        final Properties properties;
        try {
            properties = readPropertiesFile();
            readWebDriverProperties(properties);
        } catch (IOException e) {
            log.throwing(ConfigurationTestAutomation.class.getName(), ConfigurationTestAutomation.class.getName(), e);
            e.printStackTrace();
        }
    }

    private void readWebDriverProperties(Properties properties) {
        chromeDriverPath = properties.getProperty("webdriver.chrome.driver");
        geckoDriverPath = properties.getProperty("webdriver.gecko.driver");
    }
}
