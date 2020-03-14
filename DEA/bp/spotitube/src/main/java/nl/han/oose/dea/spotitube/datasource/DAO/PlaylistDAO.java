package nl.han.oose.dea.spotitube.datasource.DAO;

import nl.han.oose.dea.spotitube.datasource.connection.DatabaseProperties;

import javax.inject.Inject;

public class PlaylistDAO {

    DatabaseProperties databaseProperties;

    @Inject
    public void setDatabaseProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }


}
