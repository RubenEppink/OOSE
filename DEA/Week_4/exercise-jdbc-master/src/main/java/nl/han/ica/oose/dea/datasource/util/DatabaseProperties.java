package nl.han.ica.oose.dea.datasource.util;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class DatabaseProperties {
    private Properties properties = new Properties();

    public DatabaseProperties() {
        try {
            properties.load(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("database.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUserid() {
        return properties.getProperty("userid");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getConnectionString() {
        return properties.getProperty("connectionString");
    }

    public String getDriver() {
        return properties.getProperty("driver");
    }


}
