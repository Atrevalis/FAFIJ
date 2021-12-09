package com.example.fafij.models;

public class User {
    private static String UID;
    private static String login;
    private static User instance;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        User.login = login;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        User.UID = UID;
    }

    public static User getInstance(){
        if (instance == null){
            instance = new User();
        }
        return instance;
     }
}
