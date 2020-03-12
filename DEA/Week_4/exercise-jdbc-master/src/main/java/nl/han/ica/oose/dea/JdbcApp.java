package nl.han.ica.oose.dea;

import nl.han.ica.oose.dea.datasource.ItemDao;

import java.sql.SQLException;


public class JdbcApp {

    public static void main(String[] args) {
        ItemDao itemDao = new ItemDao();


        try {
            itemDao.findAll().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
