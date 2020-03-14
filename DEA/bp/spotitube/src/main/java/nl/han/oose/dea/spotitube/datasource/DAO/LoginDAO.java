package nl.han.oose.dea.spotitube.datasource.DAO;

import nl.han.oose.dea.spotitube.controller.dto.LoginDTO;
import nl.han.oose.dea.spotitube.controller.dto.LoginResponseDTO;
import nl.han.oose.dea.spotitube.controller.exception.InvalidCredentialsException;
import nl.han.oose.dea.spotitube.datasource.connection.DBConnection;
import nl.han.oose.dea.spotitube.domain.mapper.LoginMapper;
import nl.han.oose.dea.spotitube.domain.mapper.LogingResponseMapper;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    private DBConnection dbConnection;
    private LoginMapper loginMapper;
    private LogingResponseMapper logingResponseMapper;

    @Inject
    public void setLogingResponseMapper(LogingResponseMapper logingResponseMapper) {
        this.logingResponseMapper = logingResponseMapper;
    }

    @Inject
    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Inject
    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    public LoginDTO getLoginInfo(String username) {
        //TODO

        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE login = ?");
            stmt.setString(1, "ruben");
            ResultSet resultSet = stmt.executeQuery();
            return loginMapper.toDTO(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvalidCredentialsException();
        }
    }

    public LoginResponseDTO getUserInfo(String username) {
        //TODO fix dit
        ResultSet resultSet = null;

        try (Connection connection = dbConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE login = ?");
            stmt.setString(1, "ruben");
            resultSet = stmt.executeQuery();
            return logingResponseMapper.toDTO(resultSet);


        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvalidCredentialsException();
        }
    }

}
