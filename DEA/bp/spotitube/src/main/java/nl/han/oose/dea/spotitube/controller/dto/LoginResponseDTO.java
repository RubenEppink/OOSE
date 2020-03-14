package nl.han.oose.dea.spotitube.controller.dto;

public class LoginResponseDTO {
    private String token;
    private String user;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String token, String user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
