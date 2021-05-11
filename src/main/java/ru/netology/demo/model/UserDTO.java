package ru.netology.demo.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    public String login;
    public String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
