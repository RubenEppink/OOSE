package nl.han.oose.dea.spotitube.domain.mapper;

import nl.han.oose.dea.spotitube.controller.dto.LoginDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMapper implements DataMapper<LoginDTO> {

    @Override
    public LoginDTO toDTO(ResultSet resultset) {

        try {
            while(resultset.next()) {
                return new LoginDTO(resultset.getString("login"),
                        resultset.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new LoginDTO();
    }
    
    //TODO fix return situatie
    //exception optioneel ergens anders opvangen?
}
