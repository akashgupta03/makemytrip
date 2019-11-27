package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class PropertiesReader {
    private Properties prop = new Properties();

    PropertiesReader() {
        String environment = System.getProperty("env");
        String propertiesFilePath = environment + ".properties";
        InputStream inputStream;
        inputStream = getInputStream(propertiesFilePath);

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream getInputStream(String propertiesFilePath) {
        return this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
    }

    String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }
    String getUserName() {
        return prop.getProperty("username");
    }

    String getPassword() {
        return prop.getProperty("pwd");
    }
    String getWrongUserName() {
        return prop.getProperty("wrongUserId");
    }

    String getWrongPassword() {
        return prop.getProperty("wrongPwd");
    }
}
