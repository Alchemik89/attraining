package config;

import lombok.Getter;
import lombok.extern.java.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Log
public class ConfigurationTestAutomation {

    @Getter
    private String chromeDriverPath;
    @Getter
    private String url;
    @Getter
    private List<String> chromeDriverArguments;

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
        url = properties.getProperty("webdriver.base.url");
        readChromeDriverArguments(properties);
    }

    private void readChromeDriverArguments(Properties properties) {
        final String property = properties.getProperty("chromedriver.arguments");
        if (property != null) {
            final String[] split = property.split(";");
            chromeDriverArguments = Arrays.asList(split);
        } else {
            chromeDriverArguments = new ArrayList<>();
        }
    }
}
