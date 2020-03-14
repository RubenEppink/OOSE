package nl.han.oose.dea.spotitube.datasource.connection;

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

    public String getConnectionString() {
        return properties.getProperty("connectionString");
    }

    public String getDriver() {
        return properties.getProperty("driver");
    }


}
