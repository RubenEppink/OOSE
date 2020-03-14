package nl.han.oose.dea.spotitube.controller;

import nl.han.oose.dea.spotitube.controller.dto.LoginDTO;
import nl.han.oose.dea.spotitube.controller.dto.LoginResponseDTO;
import nl.han.oose.dea.spotitube.domain.LoginDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoginControllerTest {

    private LoginController loginControllerUnderTest;

    @BeforeEach
    void setUp() {
        loginControllerUnderTest = new LoginController();
        loginControllerUnderTest.loginDomain = mock(LoginDomain.class);
    }

    @Test
    void testValidateLogin() {
        // Setup
        final LoginDTO loginDTO = new LoginDTO("ruben", "wachtwoord");
        final LoginResponseDTO loginResponseDTO = new  LoginResponseDTO("123456", "3l1t3h4ckz0rz");
        when(loginControllerUnderTest.loginDomain.validateLogin(loginDTO)).thenReturn(loginResponseDTO);

        // Run the test
        final Response result = loginControllerUnderTest.validateLogin(loginDTO);

        // Verify the results
        Assertions.assertEquals(loginResponseDTO, result.getEntity());
    }
}
