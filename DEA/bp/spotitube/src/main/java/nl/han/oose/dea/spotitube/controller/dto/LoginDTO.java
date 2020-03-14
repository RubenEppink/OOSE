package nl.han.oose.dea.spotitube.controller.dto;

import java.util.Objects;

public class LoginDTO {
    private String user;
    private String password;

    public LoginDTO(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public LoginDTO() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(user, loginDTO.user) &&
                Objects.equals(password, loginDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }
}
