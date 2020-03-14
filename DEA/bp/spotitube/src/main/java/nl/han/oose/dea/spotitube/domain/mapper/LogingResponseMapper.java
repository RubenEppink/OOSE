package nl.han.oose.dea.spotitube.domain.mapper;

import nl.han.oose.dea.spotitube.controller.dto.LoginDTO;
import nl.han.oose.dea.spotitube.controller.dto.LoginResponseDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogingResponseMapper implements DataMapper<LoginResponseDTO> {

    @Override
    public LoginResponseDTO toDTO(ResultSet resultset) {
        try {
            while(resultset.next()) {
                return new LoginResponseDTO(resultset.getString("token"),
                        resultset.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new LoginResponseDTO();
    }
}

