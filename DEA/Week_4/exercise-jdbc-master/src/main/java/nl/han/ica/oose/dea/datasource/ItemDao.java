package nl.han.ica.oose.dea.datasource;

import nl.han.ica.oose.dea.datasource.util.DatabaseProperties;
import nl.han.ica.oose.dea.domain.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    DatabaseProperties databaseProperties = new DatabaseProperties();

    public List<Item> findAll() throws SQLException {
        List<Item> itemList = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(databaseProperties.getConnectionString());
            resultSet = connection.prepareStatement("SELECT * FROM items").executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        while (resultSet.next()) {
            itemList.add(new Item(
                    resultSet.getString("sku"),
                    resultSet.getString("category"),
                    resultSet.getString("title")));

        }

        return itemList;
    }
}
