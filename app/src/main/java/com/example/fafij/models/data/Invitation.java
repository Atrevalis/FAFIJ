package com.example.fafij.models.data;

import java.util.ArrayList;

public class Invitation {

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }


    private String journalName;

    public ArrayList<Login> getLogins() {
        return logins;
    }

    public void setLogins(ArrayList<Login> logins) {
        this.logins = logins;
    }

    private ArrayList<Login> logins;
}
