package com.example.fafij.models.data;

public class LogIn {
    private String login;
    private String hashPass;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public LogIn(String login, String hashPass) {
        this.login = login;
        this.hashPass = hashPass;
    }
}
