package nl.han.oose.dea.spotitube.domain;

import nl.han.oose.dea.spotitube.controller.dto.LoginDTO;
import nl.han.oose.dea.spotitube.controller.dto.LoginResponseDTO;
import nl.han.oose.dea.spotitube.controller.exception.InvalidCredentialsException;
import nl.han.oose.dea.spotitube.datasource.DAO.LoginDAO;

import javax.inject.Inject;

public class LoginDomain {
   private LoginDAO loginDAO;

   @Inject
    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    public LoginResponseDTO validateLogin(LoginDTO loginDTO) {
        if (loginDTO.getPassword().equals(loginDAO.getLoginInfo(loginDTO.getUser()).getPassword())) {
            return loginDAO.getUserInfo(loginDTO.getUser());
        } else {
            throw new InvalidCredentialsException();
        }
    }

}
