package nl.han.oose.dea.spotitube.datasource.connection;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//singleton??
public class SQLDBConnection implements DBConnection {
    private DatabaseProperties databaseProperties;

    public SQLDBConnection() {
    }

    @Inject
    public void setDatabaseProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

    //wel of niet exception gelijk afvangen?
    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(databaseProperties.getDriver());
        } catch (ClassNotFoundException e) {

        }
        return DriverManager.getConnection(databaseProperties.getConnectionString());
    }

    @Override
    public void closeConnection() {


    }
}
